package com.cars.cars_manager.modules.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;

public class BeforeFutureImpl implements ConstraintValidator<BeforeFuture, LocalDate> {
    @Override
    public boolean isValid(LocalDate localDate, ConstraintValidatorContext constraintValidatorContext) {
        if(localDate==null) return true; //@NotNull shte go hvane
        return localDate.isBefore(LocalDate.of(LocalDate.now().getYear()+1,1,1));
    }
}
