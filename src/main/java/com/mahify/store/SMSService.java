package com.mahify.store;

import org.springframework.stereotype.Service;

@Service
public class SMSService implements NotificationService{
    @Override
    public String send(String message) {
        return "Sending SMS: " + message;
    }
}
