package rua;

import com.crud.domain.model.entity.Coluna;
import com.crud.domain.model.entity.Rua;
import com.crud.infrastructure.repository.generic.GenericRepository;

public class ConsultarRua {
    public static void main(String[] args) {
        GenericRepository<Rua> genericRepository = new GenericRepository<>(Rua.class);
        Rua rua = genericRepository.obterPorId(1L);
        rua.getColunas().forEach(coluna -> {
            System.out.println(coluna.getId());
        });
        try{
        }finally {
            genericRepository.fechar();
        }
    }
}
