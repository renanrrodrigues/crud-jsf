package coluna;

import com.crud.domain.model.entity.Coluna;
import com.crud.domain.model.entity.Rua;
import com.crud.infrastructure.repository.GenericRepository;

public class NovaColuna {
    public static void main(String[] args) {
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
}
