package com.group.jaihanumantravels_be.controller;

import com.group.jaihanumantravels_be.common.APIResponse;
import com.group.jaihanumantravels_be.dto.UserBookingdto;
import com.group.jaihanumantravels_be.repo.UserBookingRepo;

import com.group.jaihanumantravels_be.services.UserBookingServices;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/booking/")
public class Booking {
    private UserBookingServices userBookingServices;
    private UserBookingRepo userBookingRepo;

    public Booking(UserBookingRepo userBookingRepo, UserBookingServices userBookingServices) {
        this.userBookingServices = userBookingServices;
        this.userBookingRepo = userBookingRepo;
    }

    @PostMapping("bookRide")
    public APIResponse bookRide(@RequestBody UserBookingdto userBookingdto) {

        APIResponse apiResponse = userBookingServices.saveBooking(userBookingdto);
        return apiResponse;
    }

    @GetMapping("{id}")
    public APIResponse getUerBookingById(@PathVariable("id") long id) {
        APIResponse apiResponse = userBookingServices.findBookingById(id);
        return apiResponse;
    }

    @GetMapping("userbookingHistory/userid={id}")
    public APIResponse getuserBookingHistory(@PathVariable("id") Long id) {
        APIResponse apiResponse = userBookingServices.findBookingByUserId(id);
        return apiResponse;
    }

    @GetMapping("getAllBookings")
    public APIResponse getAllBookings() {
        APIResponse apiResponse = userBookingServices.findAllBookings();
        return apiResponse;
    }

    @GetMapping("deleBooking/{id}")
    APIResponse deleteBooking(@PathVariable("id") Long id) {
        APIResponse apiResponse = userBookingServices.deleteBooking(id);
        return apiResponse;
    }

}
