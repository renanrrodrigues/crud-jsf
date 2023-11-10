package rua;

import com.crud.domain.model.entity.Rua;
import com.crud.infrastructure.repository.generic.GenericRepository;

public class NovaRua {
    public static void main(String[] args) {

        GenericRepository<Rua> genericRepository = new GenericRepository<>(Rua.class);

        Rua rua = new Rua();

        rua.setNome("A1");
        genericRepository.incluirAtomico(rua);
        genericRepository.fechar();
    }
}