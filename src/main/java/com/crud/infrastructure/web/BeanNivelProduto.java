package com.crud.infrastructure.web;

import com.crud.dto.NivelProdutoDTO;
import com.crud.infrastructure.repository.NivelProdutoRepository;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class BeanNivelProduto implements Serializable {

    private Long idRua = 0L;
    private List<NivelProdutoDTO> listaNivelProduto;

    public void obterNivelProdutoByIdRua() {
        this.listaNivelProduto = new NivelProdutoRepository().obterNivelProdutoByIdRua(this.idRua);
    }

    public Long getIdRua() {
        return idRua;
    }

    public void setIdRua(Long idRua) {
        this.idRua = idRua;
    }

    public List<NivelProdutoDTO> getListaNivelProduto() {
        return listaNivelProduto;
    }

    public void setListaNivelProduto(List<NivelProdutoDTO> listaNivelProduto) {
        this.listaNivelProduto = listaNivelProduto;
    }
}
