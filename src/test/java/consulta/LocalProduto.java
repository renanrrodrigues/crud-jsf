package consulta;

import com.crud.domain.model.entity.Produto;
import com.crud.infrastructure.repository.generic.GenericRepository;

public class LocalProduto {
    public static void main(String[] args) {
        GenericRepository<Produto> genericRepository = new GenericRepository<>(Produto.class);
        Produto produto = genericRepository.obterPorId(7L);

    }
}