package gerardados;

import com.crud.domain.model.entity.*;
import com.crud.infrastructure.repository.generic.GenericRepository;

import java.util.ArrayList;
import java.util.List;

public class GeraDados {

    private static void gerarRua() {
        GenericRepository<Rua> genericRepository = new GenericRepository<>(Rua.class);

        try
        {
            for (int i = 1; i <= 6; i++) {
                Rua rua = new Rua();
                rua.setNome("A-"+String.valueOf(i));
                genericRepository.incluirAtomico(rua);
            }
        }
        finally
        {
            genericRepository.fechar();
        }
    }

    private static void gerarColuna() {
        GenericRepository<Coluna> genericRepository = new GenericRepository<>(Coluna.class);

        try{
            for (int i = 1; i <= 6; i++) {
                Rua rua = new Rua();
                rua.setId(i);
                for (int j = 1; j <= 5; j++) {
                    Coluna coluna = new Coluna();
                    coluna.setRua(rua);
                    genericRepository.incluirAtomico(coluna);
                }
            }
        }finally {
            genericRepository.fechar();
        }
    }

    private static void gerarNivel() {
        GenericRepository<Nivel> genericRepository = new GenericRepository<>(Nivel.class);

        try{
            for (int i = 1; i <= 30; i++) {
                Coluna coluna = new Coluna();
                coluna.setId(i);
                for (int j = 1; j <= 4; j++) {
                    Nivel nivel = new Nivel();
                    nivel.setColuna(coluna);
                    genericRepository.incluirAtomico(nivel);
                }
            }
        }finally {
            genericRepository.fechar();
        }
    }

    public static void gerarCategoriasEProdutos() {
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

    public static void main(String[] args) {
        gerarRua();
        gerarColuna();
        gerarNivel();
        gerarCategoriasEProdutos();
    }
}
