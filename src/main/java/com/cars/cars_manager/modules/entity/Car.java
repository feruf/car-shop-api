package com.cars.cars_manager.modules.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "car")
public class Car {
    @Id
    @Min(value = 0, message = "Id should be greater than 0")
    private long id;
    @Column(name = "brand", nullable = false)
    @NotBlank(message = "Brand should not be blank")
    private String brand;
    @Column(name = "model", nullable = false)
    @NotBlank(message = "Model should not be blank")
    private String model;
    @NotNull
    @Column(name = "yearOfProduction", nullable = false)
    private LocalDate yearOfProduction;
    @ManyToOne
    @JoinColumn(name = "shop_id", nullable = false)
    @Setter
    private Shop shop;

}
