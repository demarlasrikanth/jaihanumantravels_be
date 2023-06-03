package com.group.jaihanumantravels_be.common;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
@Setter
@Getter
public class APIResponse {

    private Integer status;
    private Object data;
    private Object error;
    private boolean valid;
}

