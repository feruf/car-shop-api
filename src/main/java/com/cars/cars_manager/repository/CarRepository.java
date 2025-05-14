package com.cars.cars_manager.repository;

import com.cars.cars_manager.modules.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface CarRepository extends JpaRepository<Car,Long> {
    @Query("""
    SELECT c FROM Car c
    WHERE EXTRACT(YEAR FROM c.yearOfProduction) = :year
    """)
    Car findByYearOfProduction(long year);

    @Query("""
    SELECT c FROM Car c
    WHERE  
        c.id = :carId AND
        c.shop.id = :shopId 
    """)
    Car findByShopIdAndId(long shopId, long carId);
}
