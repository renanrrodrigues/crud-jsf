package rua;

import com.crud.domain.model.entity.Rua;
import com.crud.infrastructure.repository.GenericRepository;

public class NovaRua {
    public static void main(String[] args) {

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
}
