package com.jpa.relationship.dao;

import com.jpa.relationship.entity.CityEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class CityDao extends GenericDao<CityEntity> {

    public List<CityEntity> list() {
        return entityManager.createQuery("select c from CityEntity c order by c.name", CityEntity.class)
                .getResultList();
    }

    public CityEntity findById(UUID id) {
        return entityManager.createNamedQuery("city.id", CityEntity.class)
                .setParameter("id", id)
                .getSingleResult();
    }
}
