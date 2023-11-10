package com.crud.domain.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "rua")
public class Rua {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nome;



    public Rua(String nome) {
        this.nome = nome;
    }

    public Rua() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
