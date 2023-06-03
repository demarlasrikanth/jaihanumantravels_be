//package com.group.jaihanumantravels_be.Security;
//
//import com.group.jaihanumantravels_be.model.Users;
//import com.group.jaihanumantravels_be.repo.UsersRepo;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//
//@Service
//public class CustomUserDetailServices implements UserDetailsService {
//
//    private Users users;
//    private UsersRepo usersRepo;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        usersRepo.findByEmailId(username);
//        return new org.springframework.security.core
//                .userdetails.User(users.getEmailId(), users.getPassword(), new ArrayList<>());
//    }
//}
