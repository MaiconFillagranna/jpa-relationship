package com.jpa.relationship.dao;

import com.jpa.relationship.entity.SaleEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class SaleDao extends GenericDao<SaleEntity> {

    public List<SaleEntity> list() {
        return entityManager.createQuery("select c from SaleEntity c order by c.date", SaleEntity.class)
                .getResultList();
    }

    public SaleEntity findById(UUID id) {
        return entityManager.createNamedQuery("sale.id", SaleEntity.class)
                .setParameter("id", id)
                .getSingleResult();
    }
}
