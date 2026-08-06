package com.mahify.store;

import org.springframework.stereotype.Service;

public interface  NotificationService {
    void send(String message);
    void send(String message,String recipientEmail);
}
