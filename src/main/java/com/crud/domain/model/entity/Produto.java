package com.crud.domain.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 200)
    private String nome;

    @Column(nullable = false)
    private int quantidade;

    // fk de categoria
    @ManyToOne // muitos produtos para uma categoria
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;

    @OneToOne
    @JoinColumn(name = "nivel_id")
    private Nivel nivel;

    public Produto() {
    }

    public Produto(String nome, int quantidade, Categoria categoria) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.categoria = categoria;
    }

    public Produto(String nome, int quantidade, Categoria categoria, Nivel nivel) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.categoria = categoria;
        this.nivel = nivel;
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

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }
}
