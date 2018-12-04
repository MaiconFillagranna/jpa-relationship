package com.jpa.relationship.dao;

import com.jpa.relationship.entity.ProductEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class ProductDao extends GenericDao<ProductEntity> {

    public List<ProductEntity> list() {
        return entityManager.createQuery("select c from ProductEntity c order by c.name", ProductEntity.class)
                .getResultList();
    }

    public ProductEntity findById(UUID id) {
        return entityManager.createNamedQuery("product.id", ProductEntity.class)
                .setParameter("id", id)
                .getSingleResult();
    }
}
