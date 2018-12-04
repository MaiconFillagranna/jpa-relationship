package com.jpa.relationship.controller;

import com.jpa.relationship.common.ControllerBase;
import com.jpa.relationship.dao.SaleDao;
import com.jpa.relationship.entity.SaleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/sale")
public class SaleController extends ControllerBase {

    @Autowired
    private SaleDao dao;

    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
    public SaleEntity save(@RequestBody SaleEntity entity) {
        return dao.save(entity);
    }

    @GetMapping
    public List<SaleEntity> list() {
        return dao.list();
    }

    @GetMapping("/{id}")
    public SaleEntity find(@PathVariable UUID id) {
        return dao.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        SaleEntity entity = new SaleEntity();
        entity.setId(id);
        dao.delete(entity);
    }
}
