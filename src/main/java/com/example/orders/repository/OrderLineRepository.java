package com.example.orders.repository;

import com.example.orders.domain.OrderLine;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderLineRepository extends JpaRepository<OrderLine, Long> {
    List<OrderLine> findByOrderIdOrderByIdAsc(Long orderId);
}
