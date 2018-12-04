package com.jpa.relationship.controller;

import com.jpa.relationship.common.ControllerBase;
import com.jpa.relationship.dao.ProductDao;
import com.jpa.relationship.entity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/product")
public class ProductController extends ControllerBase {

    @Autowired
    private ProductDao dao;

    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
    public ProductEntity save(@RequestBody ProductEntity entity) {
        return dao.save(entity);
    }

    @GetMapping
    public List<ProductEntity> list() {
        return dao.list();
    }

    @GetMapping("/{id}")
    public ProductEntity find(@PathVariable UUID id) {
        return dao.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        ProductEntity entity = new ProductEntity();
        entity.setId(id);
        dao.delete(entity);
    }
}
