package produto;

import com.crud.domain.model.entity.Categoria;
import com.crud.domain.model.entity.Produto;
import com.crud.infrastructure.repository.generic.GenericRepository;

import java.util.ArrayList;
import java.util.List;


public class NovoProduto {
    public static void main(String[] args) {
        GenericRepository<Object> genericRepository = new GenericRepository<>(Object.class);

        List<Categoria> categorias = new ArrayList<>();
        categorias.add(new Categoria("Alimentos"));
        categorias.add(new Categoria("Bebidas"));
        categorias.add(new Categoria("Limpeza"));
        categorias.add(new Categoria("Higiene"));
        categorias.add(new Categoria("Eletrônicos"));

        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto("Arroz", 500, categorias.get(0)));
        produtos.add(new Produto("Feijão", 750, categorias.get(0)));
        produtos.add(new Produto("Macarrão", 1000, categorias.get(0)));
        produtos.add(new Produto("Farinha", 800, categorias.get(0)));
        produtos.add(new Produto("Açúcar", 1250, categorias.get(0)));

        produtos.add(new Produto("Cerveja", 5000, categorias.get(1)));
        produtos.add(new Produto("Coca-Cola", 2500, categorias.get(1)));
        produtos.add(new Produto("Guaraná", 1000, categorias.get(1)));
        produtos.add(new Produto("Suco", 1000, categorias.get(1)));
        produtos.add(new Produto("Água", 6000, categorias.get(1)));

        produtos.add(new Produto("Detergente", 1500, categorias.get(2)));
        produtos.add(new Produto("Desinfetante", 1350, categorias.get(2)));
        produtos.add(new Produto("Água Sanitária", 1230, categorias.get(2)));


        produtos.add(new Produto("Sabonete", 2000, categorias.get(3)));
        produtos.add(new Produto("Shampoo", 2500, categorias.get(3)));
        produtos.add(new Produto("Condicionador", 1350, categorias.get(3)));

        produtos.add(new Produto("Televisão", 200, categorias.get(4)));
        produtos.add(new Produto("Celular", 300, categorias.get(4)));
        produtos.add(new Produto("Notebook", 125, categorias.get(4)));
        produtos.add(new Produto("Tablet", 300, categorias.get(4)));
        produtos.add(new Produto("Fone de Ouvido", 250, categorias.get(4)));


        try{
            for (Categoria categoria : categorias) {
                genericRepository.incluirAtomico(categoria);
            }
            for (Produto produto : produtos) {
                genericRepository.incluirAtomico(produto);
            }
            genericRepository.fechar();
        }finally {
            genericRepository.fechar();
        }
    }
}
