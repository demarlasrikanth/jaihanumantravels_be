package com.group.jaihanumantravels_be.dto.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class JwtTokenDto {
    private String accessToken;
    private String tokenType = "Bearer";
}
