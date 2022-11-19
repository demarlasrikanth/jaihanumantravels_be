package com.group.jaihanumantravels_be.repo;

import com.group.jaihanumantravels_be.model.Users;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepo extends JpaRepository<Users, Long> {
    Optional<Users> findById(Long id);
    static Optional<Users> findByEmailId(String emailId) {
        // TODO Auto-generated method stub
        return null;
    }

}