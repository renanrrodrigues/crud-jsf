package consulta.nativas;

import com.crud.domain.model.entity.Produto;
import com.crud.infrastructure.factory.ManagerFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

public class ConsultasNativas {

    public static void main(String[] args) {

        EntityManager entityManager = ManagerFactory.getEntityManager();

        consultarSimplesMapeandoParaEntidade(entityManager);
        //mapeandoResultado(entityManager);

        ManagerFactory.emClose(); // fechando o Entity Manager (gerenciador de entidades)
        ManagerFactory.emfClose(); // fechando o Entity Manager Factory (fábrica de Entity Manager)
    }


    public static void consultarSimplesMapeandoParaEntidade(EntityManager entityManager) {
        // primeiro parâmetro é a query nativa, o segundo é a classe que será mapeada
        // para cada registro retornado da query
        // o nome das colunas do select devem ser iguais aos nomes dos atributos da classe
        // ao usar consultas nativas, não é possível usar JPQL, apenas SQL e podemos fazer consultas em tabelas que não estão mapeadas
        Query query1 = entityManager.createNativeQuery(
                "SELECT * FROM produto", Produto.class);

        // somos obrigados a mapear todas as colunas da tabela!
        Query query2 = entityManager.createNativeQuery(
                "SELECT " +
                        "id, " +
                        "nome, " +
                        "categoria_id " +
                        "FROM produto", Produto.class);

        // consultando uma tabela que não está mapeada usando nossa classe Produto
        Query query3 = entityManager.createNativeQuery(
                "SELECT " +
                        "id as id_p, " +
                        "nome as name, " +
                        "categoria_id id_categoria " +
                        "FROM tb_produto2", Produto.class);

        List<Produto> produtos = query2.getResultList();

        produtos.stream().forEach(produto -> {
            System.out.println(String.format("ID: %d, Nome: %s", produto.getId(), produto.getNome()));
        });
    }

    public static void mapeandoResultado(EntityManager entityManager) {

        Query query = entityManager.createNativeQuery(
                "SELECT " +
                        "id as id_p, " +
                        "nome as name, " +
                        "categoria_id id_categoria " +
                        "FROM tb_produto2", Produto.class);

        List<Produto> produtos = query.getResultList();

        produtos.stream().forEach(produto -> {
            System.out.println(String.format("" +
                    "ID: %d, " +
                    "Nome: %s",
                    produto.getId(),
                    produto.getNome()));
        });
    }
}
