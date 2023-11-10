package com.crud.domain.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "coluna")
public class Coluna {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    // rua fk
    @ManyToOne // muitas colunas para uma rua
    @JoinColumn(name = "rua_id")
    private Rua rua;

    public Coluna() {
    }

    public Coluna(Rua rua) {
        this.rua = rua;
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
}
