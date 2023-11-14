package gaurdar;

import com.crud.domain.model.entity.EstoqueItem;
import com.crud.domain.model.entity.Nivel;
import com.crud.domain.model.entity.Produto;
import com.crud.infrastructure.repository.GenericRepository;

public class GuardarProduto {
    public static void main(String[] args) {
        GenericRepository<EstoqueItem> genericRepository = new GenericRepository<>(EstoqueItem.class);
        Nivel nivel = new Nivel();
        nivel.setId(51L);

        Produto produto = new Produto();
        produto.setId(10L);

        try{
            EstoqueItem estoqueItem = new EstoqueItem();
            estoqueItem.setNivel(nivel);
            estoqueItem.setProduto(produto);
            estoqueItem.setQuantidade(25L);

            genericRepository.incluirAtomico(estoqueItem);
        }finally {
            genericRepository.fechar();
        }
    }
}
