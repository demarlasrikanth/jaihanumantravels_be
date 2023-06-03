package com.group.jaihanumantravels_be.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.io.Serializable;

@Entity
@Setter
@Getter
@ToString
@AllArgsConstructor
@Table(name = "users")
public class Users implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email_id")
    public String emailId;
    @Column(name = "phone_no")
    private String phoneNo;
    @Column(name = "password")
    @JsonIgnore
    @JsonIgnoreProperties(value = "password")
    private String password;
    @Column(name = "role_Id")
    private String roleId;

    public Users() {

    }
}
