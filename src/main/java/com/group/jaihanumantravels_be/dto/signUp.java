package com.group.jaihanumantravels_be.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
@Setter
@Getter
public class signUp {

    private Long id;

    private String firstName;

    private String lastName;

    public String emailId;

    private String phoneNo;

    private String password;
    private String roleId;
}
