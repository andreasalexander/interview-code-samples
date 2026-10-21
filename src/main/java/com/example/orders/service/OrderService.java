package com.example.orders.service;

import com.example.orders.dto.OrderResponse;
import com.example.orders.repository.OrderRepository;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {
    private final OrderRepository orders;

    public OrderService(OrderRepository orders) {
        this.orders = orders;
    }

    @Transactional(readOnly = true)
    public List<OrderResponse> findRecentOrders(Long customerId) {
        return orders.findTop20ByCustomerIdOrderByIdDesc(customerId).stream()
                .map(order -> new OrderResponse(order.getId(), order.getPlacedAt()))
                .toList();
    }
}
