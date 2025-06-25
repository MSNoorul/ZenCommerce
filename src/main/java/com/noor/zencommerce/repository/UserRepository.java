package com.noor.zencommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.noor.zencommerce.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);

    User findByEmail(String email);
}
