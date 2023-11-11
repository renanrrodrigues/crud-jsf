package gaurdar;

import com.crud.domain.model.entity.Categoria;
import com.crud.domain.model.entity.Nivel;
import com.crud.domain.model.entity.Produto;
import com.crud.infrastructure.repository.generic.GenericRepository;

public class GuardarProduto {
    public static void main(String[] args) {
        GenericRepository<Produto> genericRepository = new GenericRepository<>(Produto.class);
        Nivel nivel = new Nivel();
        nivel.setId(1L);

        try{
            genericRepository.obterPorId(1L).setNivel(nivel);
        }finally {
            genericRepository.fechar();
        }
    }
}
