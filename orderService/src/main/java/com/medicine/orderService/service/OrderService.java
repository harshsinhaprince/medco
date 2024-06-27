package com.medicine.orderService.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.medicine.orderService.model.Order;
import com.medicine.orderService.repository.OrderRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> listAll() {
        return orderRepository.findAll();
    }

    public Order save(Order order) {
        return orderRepository.save(order);
    }

    public Optional<Order> get(Long id) {
        return orderRepository.findById(id);
    }

    public void delete(Long id) {
        orderRepository.deleteById(id);
    }

    public Order processOrder(Order order) {
        // Assume PaymentServiceClient calls a payment service to process payments
        PaymentServiceClient paymentService = new PaymentServiceClient();
        order.setStatus("PENDING");
        Order savedOrder = save(order);
        boolean paymentResult = paymentService.processPayment(savedOrder.getAmount());
        if (paymentResult) {
            savedOrder.setStatus("COMPLETED");
        } else {
            savedOrder.setStatus("FAILED");
        }
        return save(savedOrder);
    }
}
