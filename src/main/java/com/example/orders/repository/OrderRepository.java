package com.example.orders.repository;

import com.example.orders.domain.CustomerOrder;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<CustomerOrder, Long> {
    List<CustomerOrder> findTop20ByCustomerIdOrderByIdDesc(Long customerId);
}
