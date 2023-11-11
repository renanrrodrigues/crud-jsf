package com.crud.domain.model.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 200)
    private String nome;


    // fk de categoria
    @ManyToOne // muitos produtos para uma categoria
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;


    public Produto() {
    }


    public Produto(String nome, Categoria categoria) {
        this.nome = nome;
        this.categoria = categoria;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
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
