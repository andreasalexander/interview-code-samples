package com.example.orders.dto;

import java.math.BigDecimal;
import java.util.List;

public record OrderSummary(Long orderId, String contactEmail, List<Item> items, BigDecimal total) {
    public record Item(String productName, int quantity, BigDecimal unitPrice) {}
}
