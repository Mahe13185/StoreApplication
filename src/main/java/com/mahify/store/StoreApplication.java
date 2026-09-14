package com.mahify.store;

import com.mahify.store.entities.Address;
import com.mahify.store.entities.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class StoreApplication {

    public static void main(String[] args) {
//        ApplicationContext context =  SpringApplication.run(StoreApplication.class, args);
        var user = User.builder()
                .id(1L)
                .name("Mahendra")
                .email("Mahendra@gamil.com")
                .build();
        var address = Address.builder()
                .street("street")
                .city("city")
                .zip("zip")
                .state("state")
                .build();



        user.addAddress(address);
        System.out.println(user);
    }

}
