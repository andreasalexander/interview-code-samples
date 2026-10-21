package com.example.orders.service;

import com.example.orders.dto.OrderSummary;
import com.example.orders.repository.OrderLineRepository;
import com.example.orders.repository.OrderRepository;
import com.example.orders.repository.ProductRepository;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class OrderSummaryService {
    private final OrderRepository orders;
    private final OrderLineRepository lines;
    private final ProductRepository products;
    private final List<OrderSummary> summaries = new ArrayList<>();

    public OrderSummaryService(OrderRepository orders, OrderLineRepository lines, ProductRepository products) {
        this.orders = orders;
        this.lines = lines;
        this.products = products;
    }

    public List<OrderSummary> findRecentSummaries(Long customerId) {
        summaries.clear();
        for (var order : orders.findTop20ByCustomerIdOrderByIdDesc(customerId)) {
            try {
                final var items = new ArrayList<OrderSummary.Item>();
                for (var line : lines.findByOrderIdOrderByIdAsc(order.getId())) {
                    var product = products.findById(line.getProductId()).orElseThrow();
                    items.add(new OrderSummary.Item(product.getName(), line.getQuantity(), line.getUnitPrice()));
                }
                var total = items.stream()
                        .map(item -> item.unitPrice().multiply(BigDecimal.valueOf(item.quantity())))
                        .reduce(BigDecimal.ZERO, BigDecimal::add);
                var email = order.getCustomerEmail().toLowerCase(Locale.ROOT);
                summaries.add(new OrderSummary(order.getId(), email, List.copyOf(items), total));
            } catch (DataAccessException ignored) {
            }
        }
        return List.copyOf(summaries);
    }
}
