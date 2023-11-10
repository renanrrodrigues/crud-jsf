package com.crud.infrastructure.repository.generic;

import com.crud.infrastructure.factory.ManagerFactory;
import jakarta.persistence.EntityManager;

public class GenericRepository<T> {
    // usamos <T> para a classe ser genérica
    // e assim poder ser usada para qualquer class
    // aqui ficariam os métodos genéricos para o CRUD
    private EntityManager em;
    private Class<T> classeEntidade;


    public GenericRepository(Class<T> classeEntidade) {
        this.em = new ManagerFactory().getEntityManager();
        this.classeEntidade = classeEntidade;
    }

    public GenericRepository<T> abrirTransacao() {
        em.getTransaction().begin();
        return this;
    }

    public GenericRepository<T> fecharTransacao() {
        em.getTransaction().commit();
        return this;
    }

    public GenericRepository<T> incluir(T entidade) {
        em.persist(entidade);
        return this;
    }

    public GenericRepository<T> incluirAtomico(T entidade) {
        return this.abrirTransacao().incluir(entidade).fecharTransacao();
    }

    public T obterPorId(Object id) {
        return em.find(classeEntidade, id);
    }

    public void remover(Object id) {
        T entidade = obterPorId(id);
        em.remove(entidade);
    }

    public void removerAtomico(Object id) {
        this.abrirTransacao().remover(id);
        //this.fecharTransacao();
    }

    public void atualizar(T entidade) {
        em.merge(entidade);
    }

    public void atualizarAtomico(T entidade) {
        this.abrirTransacao().atualizar(entidade);
        //this.fecharTransacao();
    }

    public void fechar() {
        em.close();
    }


}
