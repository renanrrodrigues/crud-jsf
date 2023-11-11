package categoria;

import com.crud.domain.model.entity.Coluna;
import com.crud.infrastructure.repository.generic.GenericRepository;
import com.crud.domain.model.entity.Categoria;
public class NovaCategoria {
    public static void main(String[] args) {
        GenericRepository<Categoria> genericRepository = new GenericRepository<>(Categoria.class);


        try{
            genericRepository.incluirAtomico(new Categoria("Eletrônico"));
        }finally {
            genericRepository.fechar();
        }
    }
}
