package com.cars.cars_manager.controller;

import com.cars.cars_manager.modules.dto.request.CarRequestDto;
import com.cars.cars_manager.modules.dto.response.CarResponseDto;
import com.cars.cars_manager.modules.entity.Car;
import com.cars.cars_manager.service.CarService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {
    private CarService service;
    @PostMapping
    public ResponseEntity<CarResponseDto> create(@Valid @RequestBody CarRequestDto car){
        CarResponseDto result = service.create(car);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping()
    public ResponseEntity<List<CarResponseDto>> viewAllCars(){
        return ResponseEntity.ok(new ArrayList<>());
    }

    @GetMapping("/{shopId}/{carId}")
    public ResponseEntity<CarResponseDto> viewCar(@PathVariable(name = "shopId") @Min(0) long shopId, @PathVariable(name = "carId") @Min(0) long carId){
        return ResponseEntity.ok(new CarResponseDto());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarResponseDto> update(@PathVariable @Min(0) long id, @Valid @RequestBody CarRequestDto car){
        return ResponseEntity.ok(new CarResponseDto());
    }

    @GetMapping("/{shopId}")
    public ResponseEntity<List<CarResponseDto>> viewCarsInShop(@PathVariable @Min(0) long id){
        return ResponseEntity.ok(new ArrayList<>());
    }
}
