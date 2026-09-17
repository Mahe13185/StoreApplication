package com.mahify.store.Service;

import com.mahify.store.entities.User;
import com.mahify.store.repositories.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Transactional
public class UserService {
    private UserRepository userRepository;
    private EntityManager entityManager;
    public void showEntityStates() {
        var user = User.builder()
                .name("Mahendra")
                .email("Mahe@gmail.com")
                .password("1234")
                .build();

        if (entityManager.contains(user))
            System.out.println("Transient");
        else
            System.out.println("Persistent / detacted");
        userRepository.save(user);

        if (entityManager.contains(user))
            System.out.println("Transient");
        else
            System.out.println("Persistent / detacted");
    }
}
