package gaurdar;

import com.crud.domain.model.entity.Categoria;
import com.crud.domain.model.entity.EstoqueItem;
import com.crud.domain.model.entity.Nivel;
import com.crud.domain.model.entity.Produto;
import com.crud.infrastructure.repository.generic.GenericRepository;

public class GuardarProduto {
    public static void main(String[] args) {
        GenericRepository<EstoqueItem> genericRepository = new GenericRepository<>(EstoqueItem.class);
        Nivel nivel = new Nivel();
        nivel.setId(2L);

        Produto produto = new Produto();
        produto.setId(1L);

        try{
            EstoqueItem estoqueItem = new EstoqueItem();
            estoqueItem.setNivel(nivel);
            estoqueItem.setProduto(produto);
            estoqueItem.setQuantidade(50L);
            genericRepository.incluirAtomico(estoqueItem);
        }finally {
            genericRepository.fechar();
        }
    }
}
