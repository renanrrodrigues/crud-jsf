package consulta;

import com.crud.domain.model.entity.EstoqueItem;
import com.crud.domain.model.entity.Produto;
import com.crud.infrastructure.repository.generic.GenericRepository;

public class LocalProduto {
    public static void main(String[] args) {
        GenericRepository<EstoqueItem> genericRepository = new GenericRepository<>(EstoqueItem.class);

        EstoqueItem estoqueItem = genericRepository.obterPorId(1L);

        try{
            estoqueItem.getProduto().getNome();
        }finally {
            genericRepository.fechar();
        }

    }
}