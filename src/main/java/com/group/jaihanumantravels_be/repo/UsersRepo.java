package com.group.jaihanumantravels_be.repo;

import com.group.jaihanumantravels_be.model.UserBooking;
import com.group.jaihanumantravels_be.model.Users;

import java.util.List;
import java.util.Optional;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepo extends JpaRepository<Users, Long> {
    @NotNull Optional<Users> findById(Long id);

    Users findByEmailIdAndPassword(String emailId, String password);

    @Query(value = "SELECT * FROM Users u WHERE u.emailId = ?", nativeQuery = true)
    List<Users> findByEmailId(String EmailId);
}
