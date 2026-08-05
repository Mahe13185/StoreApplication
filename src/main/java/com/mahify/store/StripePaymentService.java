package com.mahify.store;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("stripe")
@Primary
public class StripePaymentService implements PaymentService {
    @Value("${stripe.apiUrl}")
    private String apiUrl;

    @Value("${stripe.enabled}")
    private Boolean enabled;

    @Value("${stripe.timeout}")
    private int timeout;

    @Value("${stripe.supported-currencies}")
    private List<String> supported_currencies;

    @Override
    public void processPayment(double amount){
        System.out.println("Stripe");
        System.out.println("Api URL: " + apiUrl);
        System.out.println("Enabled: " + enabled);
        System.out.println("TimeOut: " + timeout);
        System.out.println("Supported Currencies: " + supported_currencies);
        System.out.println("Amount" + amount);

    }
}
