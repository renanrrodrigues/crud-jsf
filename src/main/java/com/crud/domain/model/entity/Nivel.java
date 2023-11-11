package com.crud.domain.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "nivel")
public class Nivel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    // fk de Coluna
    @ManyToOne // muitos níveis para uma coluna
    @JoinColumn(name = "coluna_id")
    private Coluna coluna;

    @OneToOne(mappedBy = "nivel")
    private Produto produto;


    public Nivel() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Coluna getColuna() {
        return coluna;
    }

    public void setColuna(Coluna coluna) {
        this.coluna = coluna;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }


}
