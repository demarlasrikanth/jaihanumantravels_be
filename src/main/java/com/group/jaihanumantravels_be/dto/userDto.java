package com.group.jaihanumantravels_be.dto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
@Setter
@Getter
public class userDto {
    private Long id;
    private String firstName;
    private String lastName;
    public String emailId;
    private String phoneNo;
    private String roleId;
    private String token;
}
