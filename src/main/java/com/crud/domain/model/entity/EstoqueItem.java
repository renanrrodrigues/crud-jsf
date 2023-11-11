package com.crud.domain.model.entity;

import com.sun.istack.NotNull;
import jakarta.persistence.*;

@Entity
@Table(name = "estoque_item")
public class EstoqueItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "nivel_id", unique = true)
    private Nivel nivel;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    @Column(name = "qtd_produto", nullable = false)
    private Long quantidade;


    public EstoqueItem() {
    }

    public EstoqueItem(Nivel nivel, Produto produto, Long quantidade) {
        this.nivel = nivel;
        this.produto = produto;
        this.quantidade = quantidade;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }
}
