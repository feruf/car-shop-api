package com.cars.cars_manager.modules.dto.response;

import com.cars.cars_manager.modules.entity.Shop;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CarResponseDto {
    private long id;
    private String brand;
    private String model;
    private LocalDate yearofProduction;
    private Shop shop;
}
