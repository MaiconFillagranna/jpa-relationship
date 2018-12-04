package com.jpa.relationship.dao;

import com.jpa.relationship.entity.ClientEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class ClientDao extends GenericDao<ClientEntity> {

    public List<ClientEntity> list() {
        return entityManager.createQuery("select c from ClientEntity c order by c.name", ClientEntity.class)
                .getResultList();
    }

    public ClientEntity findById(UUID id) {
        return entityManager.createNamedQuery("client.id", ClientEntity.class)
                .setParameter("id", id)
                .getSingleResult();
    }
}
