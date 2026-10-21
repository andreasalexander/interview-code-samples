package com.example.orders.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
    @Id
    private Long id;
    @Column(nullable = false)
    private String name;

    protected Product() {}

    public Long getId() { return id; }
    public String getName() { return name; }
}
