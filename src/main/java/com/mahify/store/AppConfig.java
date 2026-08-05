package com.mahify.store;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Struct;

@Configuration
public class AppConfig {

    @Value("${payment_Gateway}")
    private String paymentGateway;

    @Bean
    public PaymentService stripe(){
        return new StripePaymentService();
    }

    @Bean
    public PaymentService paypal(){
        return new PaypalPaymentService();
    }

    @Bean
    public OrderService orderService(){
        if (paymentGateway.equals("stripe")){
            return new OrderService(stripe());
        }
        return new OrderService(paypal());
    }
}
