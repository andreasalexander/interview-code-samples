package com.example.orders.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.Instant;

@Entity
@Table(name = "customer_orders")
public class CustomerOrder {
    @Id
    private Long id;
    @Column(nullable = false)
    private Long customerId;
    private String customerEmail;
    @Column(nullable = false)
    private Instant placedAt;

    protected CustomerOrder() {}

    public Long getId() { return id; }
    public Long getCustomerId() { return customerId; }
    public String getCustomerEmail() { return customerEmail; }
    public Instant getPlacedAt() { return placedAt; }
}
