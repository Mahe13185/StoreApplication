package com.mahify.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class StoreApplication {

    public static void main(String[] args) {
        ApplicationContext context =  SpringApplication.run(StoreApplication.class, args);

        var notificationManager = context.getBean(NotificationManager.class);
        notificationManager.sendNotification("Hello, this is a test message!");
    }
}
