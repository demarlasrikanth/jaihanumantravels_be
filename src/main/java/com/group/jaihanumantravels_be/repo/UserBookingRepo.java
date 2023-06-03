package com.group.jaihanumantravels_be.repo;

import com.group.jaihanumantravels_be.model.UserBooking;
import org.hibernate.sql.Delete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserBookingRepo extends JpaRepository<UserBooking, Long> {
    @Query(value = "SELECT * FROM UserBooking u WHERE u.bookUserId = ?", nativeQuery = true)
    List<UserBooking> findAllByBookUserId(Long bookingUserId);

    @Query(value = "SELECT * from UserBooking", nativeQuery = true)
    List<UserBooking> findAll();

    @Query(value = "DELETE From UserBooking u where u.id=?", nativeQuery = true)
    UserBooking deleteByid(Long id);
}
