package com.cars.cars_manager.exception;


import lombok.Builder;
import lombok.Getter;

import java.time.LocalTime;

@Builder
@Getter
public class ErrorDetail {
    private String message;
    private LocalTime time;
}
