package com.cars.cars_manager.modules.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.time.LocalDate;

@Constraint(validatedBy = BeforeFutureImpl.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface BeforeFuture {
    Integer yearNow = LocalDate.now().getYear()+1;
    String message() default "Year has to be a valid year before 2026";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
