package com.crud.domain.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "nivel")
public class Nivel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    // fk de Rua
    @ManyToOne // muitos níveis para uma rua
    @JoinColumn(name = "rua_id")
    private Rua rua;

    // fk de Coluna
    @ManyToOne // muitos níveis para uma coluna
    @JoinColumn(name = "coluna_id")
    private Coluna coluna;

    public Nivel() {
    }

    public Nivel(Rua rua, Coluna coluna) {
        this.rua = rua;
        this.coluna = coluna;
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
}
