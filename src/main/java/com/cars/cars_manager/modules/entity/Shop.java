package com.cars.cars_manager.modules.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

import java.util.List;

@Entity
@Table(name = "shop")
@Getter
public class Shop {
    @Id
    @Min(value = 0, message = "Id should be greater than 0")
    private long id;
    @NotBlank(message = "Name should not be blank")
    private String name;
    @OneToMany
    @Getter
    private List<Car> cars;

    @Min(value = 0, message = "Stock price should be higher than 0")
    private long stockPrice;
}
