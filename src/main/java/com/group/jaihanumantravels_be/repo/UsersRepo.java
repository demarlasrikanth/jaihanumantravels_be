package com.group.jaihanumantravels_be.repo;

import com.group.jaihanumantravels_be.model.Users;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UsersRepo extends JpaRepository<Users, Long> {
    Optional<Users> findById(Long id);
    Users findByEmailIdAndPassword(String emailId, String password);


//    Users DeleteUserById(Long id);
//    Users findByEmailId(String emailId);
}
