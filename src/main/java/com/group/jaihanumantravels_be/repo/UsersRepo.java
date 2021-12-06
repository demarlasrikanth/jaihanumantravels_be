package com.group.jaihanumantravels_be.repo;

import com.group.jaihanumantravels_be.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepo extends JpaRepository<Users, Long> {
}
