package com.group.jaihanumantravels_be.services;

import com.group.jaihanumantravels_be.common.APIResponse;
import com.group.jaihanumantravels_be.dto.UserBookingdto;
import com.group.jaihanumantravels_be.model.UserBooking;
import com.group.jaihanumantravels_be.repo.UserBookingRepo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class UserBookingServices {
    private final UserBookingRepo userBookingRepo;

    private UserBookingdto userBookingdto;
    private final ModelMapper modelMapper;

    public UserBookingServices(UserBookingRepo userBookingRepo, ModelMapper modelMapper) {
        this.userBookingRepo = userBookingRepo;
        this.modelMapper = modelMapper;
    }

    public APIResponse saveBooking(UserBookingdto userBookingdto) {
        APIResponse apiResponse = new APIResponse();
        if (userBookingdto == null) {
            apiResponse.setStatus(400);
            apiResponse.setError("check all required fields");
            apiResponse.setValid(false);
        } else {
            apiResponse.setStatus(200);
            apiResponse.setValid(true);
            UserBooking userBooking = this.modelMapper.map(userBookingdto, UserBooking.class);
            userBookingRepo.save(userBooking);
        }
        return apiResponse;
    }

    public APIResponse findBookingById(Long id) {
        APIResponse apiResponse = new APIResponse();

        Optional<UserBooking> userBooking = userBookingRepo.findById(id);
        if (userBooking.isPresent()) {
            apiResponse.setStatus(200);
            apiResponse.setValid(true);
            apiResponse.setData(userBooking.get());
        } else {
            apiResponse.setStatus(400);
            apiResponse.setError("id is doesn't Exits");
            apiResponse.setValid(false);
        }
        return apiResponse;
    }

    public APIResponse findBookingByUserId(Long id) {
        APIResponse apiResponse = new APIResponse();
        List<UserBooking> userBooking = userBookingRepo.findAllByBookUserId(id);
        if (userBooking.isEmpty()) {
            apiResponse.setStatus(400);
            apiResponse.setError("No Records Found");
            apiResponse.setValid(false);
        } else {
            apiResponse.setData(userBooking);
            apiResponse.setValid(true);
            apiResponse.setStatus(200);
        }
        return apiResponse;
    }

    public APIResponse findAllBookings() {
        APIResponse apiResponse = new APIResponse();
        List<UserBooking> userBooking = userBookingRepo.findAll();
        if (userBooking == null) {
            apiResponse.setValid(false);
            apiResponse.setError("No data found");
        } else {
            apiResponse.setStatus(200);
            apiResponse.setValid(true);
            apiResponse.setData(userBooking);
        }
        return apiResponse;
    }

    public APIResponse deleteBooking(Long id) {
        APIResponse apiResponse = new APIResponse();
        if (id == 0) {
            apiResponse.setStatus(400);
            apiResponse.setError("Invalid Id");
            apiResponse.setValid(false);
        } else {
            userBookingRepo.deleteByid(id);
            apiResponse.setStatus(200);
            apiResponse.setValid(true);
        }
        return apiResponse;
    }
}
