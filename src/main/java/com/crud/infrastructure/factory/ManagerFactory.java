package com.crud.infrastructure.factory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ManagerFactory {
    private static EntityManagerFactory emf;
    private EntityManager em;

    static { //  toda vez que a classe for carregada, o bloco static será executado
        // isso ocorre quando iniciamos a aplicação
        try{
            emf = Persistence
                    .createEntityManagerFactory("projeto-estoque");
        } catch (Exception e) {
            // logar -> log4j
            e.printStackTrace();
        }
    }

    public EntityManager getEntityManager() {
        try {
            em = emf.createEntityManager();
            return em;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
