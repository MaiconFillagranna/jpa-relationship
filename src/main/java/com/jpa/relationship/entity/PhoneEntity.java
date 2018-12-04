package com.jpa.relationship.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.jpa.relationship.common.CommonEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity(name = "phone")
@Table(name = "phone")
public class PhoneEntity implements CommonEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private UUID id;
    @Column
    private Integer internationalCode;
    @Column
    private Integer localCode;
    @Column
    private String number;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    private ClientEntity client;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Integer getInternationalCode() {
        return internationalCode;
    }

    public void setInternationalCode(Integer internationalCode) {
        this.internationalCode = internationalCode;
    }

    public Integer getLocalCode() {
        return localCode;
    }

    public void setLocalCode(Integer localCode) {
        this.localCode = localCode;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public ClientEntity getClient() {
        return client;
    }

    public void setClient(ClientEntity client) {
        this.client = client;
    }
}
