package com.mahify.store.repositories;

import com.mahify.store.entities.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    @EntityGraph(attributePaths = "tags")
    Optional<User> findByEmail(String email);
}