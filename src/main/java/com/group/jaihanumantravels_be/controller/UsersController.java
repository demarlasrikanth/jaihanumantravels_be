package com.group.jaihanumantravels_be.controller;

import com.group.jaihanumantravels_be.common.APIResponse;
import com.group.jaihanumantravels_be.dto.Logindto;
import com.group.jaihanumantravels_be.dto.signUp;
import com.group.jaihanumantravels_be.exception.ResourceNotFoundException;
import com.group.jaihanumantravels_be.model.Users;
import com.group.jaihanumantravels_be.repo.UsersRepo;
import com.group.jaihanumantravels_be.services.UsersServices;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/users/")
public class UsersController {
    private final UsersRepo usersRepo;

    private final UsersServices usersServices;

    public UsersController(UsersRepo usersRepo, UsersServices usersServices) {
        this.usersRepo = usersRepo;
        this.usersServices = usersServices;
    }

    // get all users
    @GetMapping("allusers")
    public List<Users> getAllEmployees() {

        return usersRepo.findAll();
    }

    // post api
    @PostMapping("addusers")
    public Users addUser(@RequestBody Users user) {

        return usersRepo.save(user);
    }

    // post api
    @PutMapping("editusers")
    public Users editUser(@RequestBody Users user) {
        if (user.getId() == null) {
            throw new ResourceNotFoundException("please provide userId ");
        }
        return usersRepo.save(user);
    }

    @GetMapping("{id}")
    public Optional<Users> getUserById(@PathVariable("id") long id) {
        return usersRepo.findById(id);
    }

    @PostMapping("login")
    public ResponseEntity<APIResponse> logIn(@RequestBody Logindto loginDto) {
        APIResponse user = usersServices.login(loginDto);
        if (user.getStatus() == 200) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        return new ResponseEntity<>(user, HttpStatus.UNAUTHORIZED);
    }

    @GetMapping("deleteUser/{id}")
    public APIResponse deleteUser(@PathVariable("id") long id) {
        APIResponse apiResponse = usersServices.delete(id);
        return apiResponse;
    }

    @PostMapping("register")
    public APIResponse processRegister(Users user) {
        APIResponse api = usersServices.signUp(user);
        return api;
    }
}
