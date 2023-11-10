package coluna;

import com.crud.domain.model.entity.Coluna;
import com.crud.domain.model.entity.Rua;
import com.crud.infrastructure.repository.generic.GenericRepository;

public class NovaColuna {
    public static void main(String[] args) {
        GenericRepository<Coluna> genericRepository = new GenericRepository<>(Coluna.class);

        try{
            for (int i = 1; i <= 10; i++) {
                Coluna coluna = new Coluna();
                genericRepository.incluirAtomico(coluna);
            }
        }finally {
            genericRepository.fechar();
        }
    }
}
