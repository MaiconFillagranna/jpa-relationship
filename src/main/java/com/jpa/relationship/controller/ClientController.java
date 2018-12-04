package com.jpa.relationship.controller;

import com.jpa.relationship.common.ControllerBase;
import com.jpa.relationship.dao.ClientDao;
import com.jpa.relationship.entity.ClientEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/client")
public class ClientController extends ControllerBase {

    @Autowired
    private ClientDao dao;

    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
    public ClientEntity save(@RequestBody ClientEntity entity) {
        return dao.save(entity);
    }

    @GetMapping
    public List<ClientEntity> list() {
        return dao.list();
    }

    @GetMapping("/{id}")
    public ClientEntity find(@PathVariable UUID id) {
        return dao.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        ClientEntity entity = new ClientEntity();
        entity.setId(id);
        dao.delete(entity);
    }
}
