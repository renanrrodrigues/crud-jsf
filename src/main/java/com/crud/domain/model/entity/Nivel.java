package com.crud.domain.model.entity;

import jakarta.persistence.*;

import java.util.List;

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

    @OneToMany(mappedBy = "nivel")
    private List<EstoqueItem> estoqueItens;


    public Nivel(Coluna coluna) {
        this.coluna = coluna;
    }

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

    public List<EstoqueItem> getEstoqueItens() {
        return estoqueItens;
    }

    public void setEstoqueItens(List<EstoqueItem> estoqueItens) {
        this.estoqueItens = estoqueItens;
    }
}
