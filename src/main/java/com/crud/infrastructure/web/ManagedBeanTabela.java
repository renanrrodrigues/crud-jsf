package com.crud.infrastructure.web;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jakarta.annotation.PostConstruct;


@Named
@ViewScoped
public class ManagedBeanTabela implements Serializable {
    private List<Integer> colunas;

    private List<Integer> niveis;

    @PostConstruct // Executado após o construtor
    public void init() {
        // Defina o número de linhas e colunas desejado
        int numNiveis = 4;
        int numColunas = 5;

        niveis = new ArrayList<>();
        for (int i = 0; i < numNiveis; i++) {
            niveis.add(i);
        }

        colunas = new ArrayList<>();
        for (int i = 0; i < numColunas; i++) {
            colunas.add(i);
        }
    }

    public List<Integer> getNiveis() {
        return niveis;
    }

    public List<Integer> getColunas() {
        return colunas;
    }
}
