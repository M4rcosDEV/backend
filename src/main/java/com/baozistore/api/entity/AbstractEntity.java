package com.baozistore.api.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@MappedSuperclass
public class AbstractEntity <ID extends Serializable> implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private ID id;

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }
}
