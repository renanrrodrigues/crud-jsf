package com.crud.dto;

import java.util.Objects;

public class NivelProdutoDTO {

    private long nivelId;
    private long quantidadeProduto;
    private long produtoId;
    private String produtoNome;

    public NivelProdutoDTO(long nivelId, long quantidadeProduto, long produtoId, String produtoNome) {
        this.nivelId = nivelId;
        this.quantidadeProduto = quantidadeProduto;
        this.produtoId = produtoId;
        this.produtoNome = produtoNome;
    }

    public void setNivelId(long nivelId) {
        this.nivelId = nivelId;
    }

    public void setQuantidadeProduto(long quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }

    public void setProdutoId(long produtoId) {
        this.produtoId = produtoId;
    }

    public void setProdutoNome(String produtoNome) {
        this.produtoNome = produtoNome;
    }

    public long getNivelId() {
        return nivelId;
    }

    public long getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public long getProdutoId() {
        return produtoId;
    }

    public String getProdutoNome() {
        return produtoNome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NivelProdutoDTO that = (NivelProdutoDTO) o;
        return nivelId == that.nivelId && quantidadeProduto == that.quantidadeProduto && produtoId == that.produtoId && Objects.equals(produtoNome, that.produtoNome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nivelId, quantidadeProduto, produtoId, produtoNome);
    }
}
