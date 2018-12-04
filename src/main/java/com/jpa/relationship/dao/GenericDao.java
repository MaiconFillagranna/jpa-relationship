package com.jpa.relationship.dao;

import com.jpa.relationship.common.CommonEntity;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class GenericDao<T extends CommonEntity> {

    @PersistenceContext
    public EntityManager entityManager;

    public T save(T entity) {
         entityManager.persist(entity);
         return entity;
    }

    public void delete(T entity) {
        Object object = entityManager.merge(entity); // contorno situacao com objeto detached
        entityManager.remove(object);
    }
}
