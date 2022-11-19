package com.group.jaihanumantravels_be.controller;

import com.group.jaihanumantravels_be.exception.ResourceNotFoundException;
import com.group.jaihanumantravels_be.model.Users;
import com.group.jaihanumantravels_be.repo.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/")
public class UsersController {
    @Autowired
    private UsersRepo usersRepo;

    // get all users
    @GetMapping("users")
    public List<Users> getAllEmployees() {
        return usersRepo.findAll();
    }

    // post api
    @PostMapping("add/users")
    public Users addUser(@RequestBody Users user) {

        return usersRepo.save(user);
    }

    // post api
    @PutMapping("edit/users")
    public Users editUser(@RequestBody Users user) {
        if (user.getId() == null) {
            throw new ResourceNotFoundException("please provide userId ");
        }
        return usersRepo.save(user);
    }

    @GetMapping("user/{id}")
    public Optional<Users> getUserById(@PathVariable("id") long id) {
        return usersRepo.findById(id);
    }

    /*
     * @PostMapping("login")
     * public Optional<Users> login(@RequestBody String emailId, String password) {
     * debugger
     * return usersRepo.findByCredentials(emailId, password);
     * }
     */
    /**

     */
   /*  @PostMapping("login")
    public Optional<Users> login(@RequestBody ) {
        Optional<Users> user = UsersRepo.findByEmailId(emailId);
        if (user.get().getPassword() == password) {
            return user;
        } else {
            throw new ResourceNotFoundException("invalid ");
        }

    } */
}
