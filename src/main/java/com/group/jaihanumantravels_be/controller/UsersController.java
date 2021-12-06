package com.group.jaihanumantravels_be.controller;

import com.group.jaihanumantravels_be.model.Users;
import com.group.jaihanumantravels_be.repo.UsersRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class UsersController {
    private UsersRepo usersRepo;
    //get all users
    @GetMapping("/users")
    public List<Users> getAllEmployees(){
        return usersRepo.findAll();
    }
}
