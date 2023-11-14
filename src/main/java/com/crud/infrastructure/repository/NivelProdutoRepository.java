package com.crud.infrastructure.repository;

import com.crud.dto.NivelProdutoDTO;
import com.crud.infrastructure.factory.ManagerFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class NivelProdutoRepository {


    public List<NivelProdutoDTO> obterNivelProdutoByIdRua(long id) {

        EntityManager entityManager = ManagerFactory.getEntityManager();

        String jpql = "SELECT new com.crud.dto.NivelProdutoDTO(n.id, ei.quantidade, p.id, p.nome) " +
                "FROM Nivel n " +
                "JOIN n.estoqueItens ei " +
                "JOIN ei.produto p " +
                "WHERE n.coluna.rua.id = :idRua";

        TypedQuery<NivelProdutoDTO> typedQueryDto = entityManager.createQuery(jpql, NivelProdutoDTO.class)
                .setParameter("idRua", id);
        List<NivelProdutoDTO> listaNivelProduto = typedQueryDto.getResultList();

        ManagerFactory.emClose(); // fechando o Entity Manager (gerenciador de entidades)

        return listaNivelProduto;
    }
}
