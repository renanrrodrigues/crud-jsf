package com.crud.domain.model.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "coluna")
public class Coluna {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne // Muitas colunas para uma rua
    @JoinColumn(name = "rua_id") // Nome da coluna que vai ser criada na tabela coluna
    private Rua rua;

    @OneToMany(mappedBy = "coluna", fetch = FetchType.LAZY) // Uma coluna para muitos níveis
    private List<Nivel> niveis;

    public Coluna() {
    }

    public Rua getRua() {
        return rua;
    }

    public void setRua(Rua rua) {
        this.rua = rua;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Nivel> getNiveis() {
        return niveis;
    }

    public void setNiveis(List<Nivel> niveis) {
        this.niveis = niveis;
    }
}
