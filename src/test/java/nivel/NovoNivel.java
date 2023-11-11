package nivel;

import com.crud.domain.model.entity.Coluna;
import com.crud.domain.model.entity.Nivel;
import com.crud.domain.model.entity.Rua;
import com.crud.infrastructure.repository.generic.GenericRepository;
import jakarta.persistence.GeneratedValue;

public class NovoNivel {
    public static void main(String[] args) {
        GenericRepository<Nivel> genericRepository = new GenericRepository<>(Nivel.class);




        try{
            for (int i = 1; i <= 30; i++) {
                Coluna coluna = new Coluna();
                coluna.setId(i);
                for (int j = 1; j <= 4; j++) {
                    Nivel nivel = new Nivel();
                    nivel.setColuna(coluna);
                    genericRepository.incluirAtomico(nivel);
                }
            }
        }finally {
            genericRepository.fechar();
        }
    }
}
