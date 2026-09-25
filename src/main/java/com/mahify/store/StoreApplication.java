package com.mahify.store;

import com.mahify.store.Service.UserService;
import com.mahify.store.entities.Address;
import com.mahify.store.entities.Profile;
import com.mahify.store.entities.Tag;
import com.mahify.store.entities.User;
import com.mahify.store.repositories.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class StoreApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(StoreApplication.class, args);
        var service = context.getBean(UserService.class);
        service.showEntityStates();
//        testing for branching from branch "Testing"
//        testing for ganesh
    }
}