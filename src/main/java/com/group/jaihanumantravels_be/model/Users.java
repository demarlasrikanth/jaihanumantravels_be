package com.group.jaihanumantravels_be.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@Entity
@Table(name="users")

public class Users implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="email_id")
    public String emailId;
    @Column(name="phone_no")
    private String phoneNo;
    @Column(name="password")
    @JsonIgnore
    @JsonIgnoreProperties(value = "password")
    private String password;
    @Column(name="role_Id")
    private String roleId;
   
    public Users(){

    }

    public Users(String firstName, String lastName, String emailId, String phoneNo, String password,String roleId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.phoneNo = phoneNo;
        this.password = password;
        this.roleId=roleId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

}
