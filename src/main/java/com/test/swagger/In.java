package com.test.swagger;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Desc In
 * @Author LiuYunLong
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = InValidator.class)
public @interface In {

	 String message() default "值必须在指定的范围内";

	 Class<?>[] groups() default {};

	 Class<? extends Payload>[] payload() default {};

	 String[] value();
}
