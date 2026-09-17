package com.mahify.store;

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
        ApplicationContext context =  SpringApplication.run(StoreApplication.class, args);
        var repo = context.getBean(UserRepository.class);

        var user = User.builder()
                .name("mahendra")
                .email("Mahe@gmail")
                .password("Mahe")
                .build();
//
//        repo.save(user);
//        System.out.println(user);

        var user1= repo.findById(1L);
        System.out.println(user1.get().getName());

        repo.findAll().forEach(u -> System.out.println(u.getName()));

        repo.deleteById(1L);
    }

}
