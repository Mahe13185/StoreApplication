package com.mahify.store;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

//@Service
public class OrderService {
    private PaymentService paymentService;

    public OrderService(@Qualifier("stripe") PaymentService paymentService){
        this.paymentService = paymentService;
        System.out.println("Service is created");
    }

    public void placeOrder(){
        paymentService.processPayment(100);


    }
}
