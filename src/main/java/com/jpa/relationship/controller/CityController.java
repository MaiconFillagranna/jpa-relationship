package com.jpa.relationship.controller;

import com.jpa.relationship.common.ControllerBase;
import com.jpa.relationship.dao.CityDao;
import com.jpa.relationship.entity.CityEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/city")
public class CityController extends ControllerBase {

    @Autowired
    private CityDao dao;

    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
    public CityEntity save(@RequestBody CityEntity entity) {
        return dao.save(entity);
    }

    @GetMapping
    public List<CityEntity> list() {
        return dao.list();
    }

    @GetMapping("/{id}")
    public CityEntity find(@PathVariable UUID id) {
        return dao.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        CityEntity entity = new CityEntity();
        entity.setId(id);
        dao.delete(entity);
    }
}
