package com.mahify.store;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class EmailService implements NotificationService{
    @Override
    public String send(String message) {
        return "Sending Email: " + message;
    }
}
