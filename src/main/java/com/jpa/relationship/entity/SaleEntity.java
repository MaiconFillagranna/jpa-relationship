package com.jpa.relationship.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.jpa.relationship.common.CommonEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "sale")
@NamedQuery(name = "sale.id", query = "select c from SaleEntity c where c.id = :id order by c.date")
public class SaleEntity implements CommonEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private UUID id;
    @ManyToOne(optional = false)
    @JoinColumn(name="client_id")
    private ClientEntity client;

    @ManyToMany
    @JoinTable(name = "sale_product", joinColumns = { @JoinColumn(name = "sale_id") }, inverseJoinColumns = { @JoinColumn(name = "product_id") })
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    private Set<ProductEntity> products;

    @Column
    private LocalDate date;
    @Column
    private Double total;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public ClientEntity getClient() {
        return client;
    }

    public void setClient(ClientEntity client) {
        this.client = client;
    }

    public Set<ProductEntity> getProducts() {
        return products;
    }

    public void setProducts(Set<ProductEntity> products) {
        this.products = products;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
