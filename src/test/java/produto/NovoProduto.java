package produto;

import com.crud.domain.model.entity.Categoria;
import com.crud.domain.model.entity.Produto;
import com.crud.infrastructure.repository.GenericRepository;

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
        produtos.add(new Produto("Arroz", categorias.get(0)));
        produtos.add(new Produto("Feijão", categorias.get(0)));
        produtos.add(new Produto("Macarrão", categorias.get(0)));
        produtos.add(new Produto("Farinha", categorias.get(0)));
        produtos.add(new Produto("Açúcar", categorias.get(0)));

        produtos.add(new Produto("Cerveja", categorias.get(1)));
        produtos.add(new Produto("Coca-Cola",  categorias.get(1)));
        produtos.add(new Produto("Guaraná",  categorias.get(1)));
        produtos.add(new Produto("Suco", categorias.get(1)));
        produtos.add(new Produto("Água", categorias.get(1)));

        produtos.add(new Produto("Detergente", categorias.get(2)));
        produtos.add(new Produto("Desinfetante", categorias.get(2)));
        produtos.add(new Produto("Água Sanitária", categorias.get(2)));


        produtos.add(new Produto("Sabonete", categorias.get(3)));
        produtos.add(new Produto("Shampoo", categorias.get(3)));
        produtos.add(new Produto("Condicionador", categorias.get(3)));

        produtos.add(new Produto("Televisão", categorias.get(4)));
        produtos.add(new Produto("Celular", categorias.get(4)));
        produtos.add(new Produto("Notebook", categorias.get(4)));
        produtos.add(new Produto("Tablet", categorias.get(4)));
        produtos.add(new Produto("Fone de Ouvido", categorias.get(4)));


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
