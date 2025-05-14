package com.cars.cars_manager.modules.dto.request;

import com.cars.cars_manager.modules.validator.BeforeFuture;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
public class CarRequestDto {
    @NotBlank(message = "Brand should not be blank")
    @Size(min = 0, max = 255, message = "Brand should be greater than 0 and less than 255")
    private String brand;
    @NotBlank(message = "Model should not be blank")
    @Size(min = 0, max = 255, message = "Model should be greater than 0 and less than 255")
    private String model;
    @BeforeFuture(message = "Year of production should be a valid year!")
    @NotNull
    private LocalDate yearOfProduction;
    @NotNull
    @Min(0)
    private long shopId;
}
