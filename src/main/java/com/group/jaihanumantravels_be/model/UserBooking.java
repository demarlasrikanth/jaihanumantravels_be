package com.group.jaihanumantravels_be.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "userbooking")
// @NamedQuery(name = "userbooking.findAllByBookUserId", query = "select * from UserBooking where bookUserId = ?")
public class UserBooking implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "vechile_type")
    private Long vechile_type;
    @Column(name = "raid_type")
    private Long raid_type;
    @Column(name = "passengers_count")
    private Long passengers_count;
    @Column(name = "aadhaar_no")
    private String aadhaar_no;
    @Column(name = "pickup_location")
    private String pickup_location;
    @Column(name = "pickup_Date")
    private String pickup_Date;
    @Column(name = "drop_Location")
    private String drop_Location;
    @Column(name = "drop_Date")
    private String drop_Date;

    @Column(name = "bookUserId")
    private Long bookUserId;
    @Column(name = "driving_license")
    private String driving_license;

}
