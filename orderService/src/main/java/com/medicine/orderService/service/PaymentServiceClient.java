package com.medicine.orderService.service;

import java.math.BigDecimal;

public class PaymentServiceClient {
	
	 public boolean processPayment(BigDecimal amount) {
	        // Mock payment processing
	        return Math.random() > 0.5;
	    }

}
