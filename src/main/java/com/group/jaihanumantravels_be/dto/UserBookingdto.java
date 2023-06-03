package com.group.jaihanumantravels_be.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserBookingdto {
    private Long vechile_type;
    private Long raid_type;
    private Long passengers_count;
    private String aadhaar_no;
    private String pickup_location;
    private String pickup_Date;
    private String drop_Location;
    private String drop_Date;
    private Long bookUserId;
    private String driving_license;
}
