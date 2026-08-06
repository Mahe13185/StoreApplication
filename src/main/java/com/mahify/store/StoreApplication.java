package com.mahify.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class StoreApplication {

    public static void main(String[] args) {
        ApplicationContext context =  SpringApplication.run(StoreApplication.class, args);
       var userService =  context.getBean(UserService.class);
       userService.registerUser(new User(1l,"mahendraGampala2005@gmail.com","mahendra","Mahendra"));
       userService.registerUser(new User(1l,"mahendraGampala2005@gmail.com","mahendra","Mahendra"));

       //        var orderService = context.getBean(OrderService.class);
//        orderService.placeOrder();
    }
}
