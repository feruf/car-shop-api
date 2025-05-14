package com.cars.cars_manager.service;

import com.cars.cars_manager.modules.dto.request.CarRequestDto;
import com.cars.cars_manager.modules.dto.response.CarResponseDto;

import java.util.List;

public interface CarService {
    public CarResponseDto create(CarRequestDto carDto);
    public List<CarResponseDto> viewAllCars();
    public CarResponseDto viewCar(long shopId, long carId);
    public CarResponseDto update(long id, CarRequestDto carDto);
    public List<CarResponseDto> viewCarsInShop(long id);
}
