package com.medicine.orderService.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.medicine.orderService.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}

