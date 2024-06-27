package com.medicine.paymentService.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.medicine.paymentService.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}

