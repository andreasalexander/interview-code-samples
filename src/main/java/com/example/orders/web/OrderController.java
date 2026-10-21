package com.example.orders.web;

import com.example.orders.dto.OrderResponse;
import com.example.orders.dto.OrderSummary;
import com.example.orders.service.OrderService;
import com.example.orders.service.OrderSummaryService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customers/{customerId}/orders")
public class OrderController {
    private final OrderService orders;
    private final OrderSummaryService summaries;

    public OrderController(OrderService orders, OrderSummaryService summaries) {
        this.orders = orders;
        this.summaries = summaries;
    }

    @GetMapping
    public List<OrderResponse> findOrders(@PathVariable Long customerId) {
        return orders.findRecentOrders(customerId);
    }

    @GetMapping("/summaries")
    public List<OrderSummary> findSummaries(@PathVariable Long customerId) {
        return summaries.findRecentSummaries(customerId);
    }
}
