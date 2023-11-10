package com.crud.domain.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "sequencia")
public class Sequencia{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    // fk de Rua
    @ManyToOne // muitas sequencias para uma rua
    @JoinColumn(name = "rua_id")
    private Rua rua;

    // fk de Coluna
    @ManyToOne // muitas sequencias para uma coluna
    @JoinColumn(name = "coluna_id")
    private Coluna coluna;

    // fk de Nivel
    @ManyToOne // muitas sequencias para um nivel
    @JoinColumn(name = "nivel_id")
    private Nivel nivel;

    // fk de Produto
    @OneToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;


    public Sequencia() {
    }

    public Sequencia(Rua rua, Coluna coluna, Nivel nivel, Produto produto) {
        this.rua = rua;
        this.coluna = coluna;
        this.nivel = nivel;
        this.produto = produto;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Rua getRua() {
        return rua;
    }

    public void setRua(Rua rua) {
        this.rua = rua;
    }

    public Coluna getColuna() {
        return coluna;
    }

    public void setColuna(Coluna coluna) {
        this.coluna = coluna;
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
}
