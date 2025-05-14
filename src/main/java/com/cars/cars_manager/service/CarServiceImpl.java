package com.cars.cars_manager.service;

import com.cars.cars_manager.modules.dto.request.CarRequestDto;
import com.cars.cars_manager.modules.dto.response.CarResponseDto;
import com.cars.cars_manager.modules.entity.Car;
import com.cars.cars_manager.modules.entity.Shop;
import com.cars.cars_manager.repository.CarRepository;
import com.cars.cars_manager.repository.ShopRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Service
public class CarServiceImpl implements CarService{
    private final CarRepository carRepository;
    private final ModelMapper mapper;
    private final ShopRepository shopRepository;

    public CarServiceImpl(CarRepository repository, ModelMapper mapper, ShopRepository shopRepository) {
        this.carRepository = repository;
        this.mapper = mapper;
        this.shopRepository = shopRepository;
    }


    @Override
    public CarResponseDto create(CarRequestDto carDto) {
        Shop shop = mapper.map(
                shopRepository.findById(carDto.getShopId()).orElseThrow(()->new IllegalArgumentException("Shop not found"))
                ,Shop.class);

        Car carToCreate = mapper.map(carDto, Car.class);

        carToCreate.setShop(shop);
        carToCreate = carRepository.save(carToCreate);
        CarResponseDto result = mapper.map(carToCreate, CarResponseDto.class);
        return result;
    }

    @Override
    public List<CarResponseDto> viewAllCars() {
        List<Car> cars = carRepository.findAll();
        Type listType = new TypeToken<List<CarResponseDto>>() {}.getType();
        List<CarResponseDto> result = mapper.map(cars,listType);
        return result;
    }

    @Override
    public CarResponseDto viewCar(long shopId, long carId) {
        Shop shop = mapper.map(
                shopRepository.findById(shopId).orElseThrow(()->new IllegalArgumentException("No shop found")),
                Shop.class
        );
        Car carToFind = null;

        for(Car car : shop.getCars()){
            if(car.getId() == carId) {
                carToFind = car;
                break;
            }
        }
        if(carToFind == null) throw new IllegalArgumentException("No car found in shop");

        return mapper.map(carToFind, CarResponseDto.class);

    }

    @Override
    public CarResponseDto update(long id, CarRequestDto carDto) {
        Shop shop = mapper.map(
                shopRepository.findById(carDto.getShopId()).orElseThrow(()->new IllegalArgumentException("No shop found")),
                Shop.class);

        Car car = carRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Car not found"));
        mapper.map(carDto, car);
        car.setShop(shop);
        car = carRepository.save(car);
        CarResponseDto result = mapper.map(car, CarResponseDto.class);
        return result;
    }

    @Override
    public List<CarResponseDto> viewCarsInShop(long id) {
        Shop shop = shopRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Shop not found"));
        List<Car> cars = shop.getCars();
        Type listType = new TypeToken<List<CarResponseDto>>() {}.getType();
        return mapper.map(cars, listType);
    }
}
