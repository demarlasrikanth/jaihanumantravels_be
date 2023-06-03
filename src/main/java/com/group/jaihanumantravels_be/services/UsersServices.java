package com.group.jaihanumantravels_be.services;


import javax.transaction.Transactional;

import com.group.jaihanumantravels_be.dto.userDto;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.jaihanumantravels_be.common.APIResponse;
import com.group.jaihanumantravels_be.dto.Logindto;
import com.group.jaihanumantravels_be.model.Users;
import com.group.jaihanumantravels_be.repo.UsersRepo;



@Transactional
@RequiredArgsConstructor
@Service
public class UsersServices {
    @Autowired
    private UsersRepo userRepo;

    public APIResponse login(Logindto loginDto) {

        APIResponse apiResponse = new APIResponse();
        Users user = userRepo.findByEmailIdAndPassword(loginDto.getEmailId(), loginDto.getPassword());
        userDto responseUser=new userDto();
        responseUser.setId(user.getId());
        responseUser.setFirstName(user.getFirstName());
        responseUser.setLastName(user.getLastName());
        responseUser.setEmailId(user.getEmailId());
        responseUser.setPhoneNo(user.getPhoneNo());
        responseUser.setRoleId(user.getRoleId());
//        responseUser.setToken(jwt);

        apiResponse.setData(responseUser);
        apiResponse.setStatus(200);

        return apiResponse;

    }

    public APIResponse delete(Long id) {
        APIResponse apiResponse = new APIResponse();
        Users user = userRepo.getById(id);
        apiResponse.setValid(true);
        apiResponse.setStatus(200);
        userRepo.deleteById(id);
        return apiResponse;
    }

    public APIResponse signUp(@NotNull Users user) {
        APIResponse apiResponse = new APIResponse();
        String emailid = user.getEmailId();
        String firstName = user.getEmailId();
        String lastName = user.getEmailId();
        String phoneNo = user.getEmailId();
        String password = user.getPassword();
        if (emailid == null || firstName == null || lastName == null || password == null || phoneNo == null) {
            apiResponse.setStatus(400);
            apiResponse.setError("please fill required fileds ");

        } else {
            apiResponse.setStatus(200);
            userRepo.save(user);
            apiResponse.setData(user);
        }

        return apiResponse;
    }
}
