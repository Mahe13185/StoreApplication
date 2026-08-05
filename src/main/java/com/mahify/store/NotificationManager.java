package com.mahify.store;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class NotificationManager {
    private NotificationService notificationService;
    NotificationManager(@Qualifier("SMSService") NotificationService notificationService){
        this.notificationService = notificationService;
    }

    void sendNotification(String message){
        System.out.println(notificationService.send(message));
    }
}
