package demo;

import com.crud.domain.model.entity.Categoria;
import com.crud.domain.model.entity.Produto;
import com.crud.dto.NivelProdutoDTO;
import com.crud.infrastructure.factory.ManagerFactory;
import com.crud.infrastructure.repository.GenericRepository;
import com.crud.infrastructure.repository.NivelProdutoRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

public class ConsultasWeb {
    public static void main(String[] args) {


        nivelProduto(); // pega todos os produtos da rua 1 e seus níveis
        //novoProduto(); // insere um novo

    }


    public static void nivelProduto() {

        List<NivelProdutoDTO> listaNivelProduto = new NivelProdutoRepository().obterNivelProdutoByIdRua(1L);

        listaNivelProduto.forEach(nivelProdutoDTO -> {
            System.out.println(nivelProdutoDTO);
            System.out.println("Id Nivel: " + nivelProdutoDTO.getNivelId());
            System.out.println("Quantidade: " + nivelProdutoDTO.getQuantidadeProduto());
            System.out.println("Id Produto: " + nivelProdutoDTO.getProdutoId());
            System.out.println("Nome Produto: " + nivelProdutoDTO.getProdutoNome());
            System.out.println();
        });
    }

    public static void novoProduto() {

        EntityManager entityManager = ManagerFactory.getEntityManager();
        entityManager.getTransaction().begin();

        Query query =  entityManager.createQuery("INSERT INTO Produto (nome, categoria) " +
                "SELECT 'Copo'," +
                " c FROM Categoria c " +
                "WHERE c.id = :categoriaId");
        query.setParameter("categoriaId", 2L);
        query.executeUpdate();
        entityManager.getTransaction().commit();

        ManagerFactory.emClose(); // fechando o Entity Manager (gerenciador de entidades)
        ManagerFactory.emfClose(); // fechando o Entity Manager Factory (fábrica de Entity Manager)

    }
}
