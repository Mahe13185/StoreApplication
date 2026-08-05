package com.mahify.store;

import org.springframework.stereotype.Service;

//@Service("paypal")
public class PaypalPaymentService implements PaymentService{
    @Override
    public void processPayment(double amount) {
        System.out.println("Paypal");
        System.out.println("Amount: " + amount);
    }
}
