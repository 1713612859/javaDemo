package com.test.swagger;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.List;

/**
 * @Desc InValidator
 * @Author LiuYunLong
 */
public class InValidator implements ConstraintValidator<In, String> {

	 private List<String> allowedValues;

	 @Override
	 public void initialize(In constraintAnnotation) {
		  allowedValues = Arrays.asList(constraintAnnotation.value());
	 }

	 @Override
	 public boolean isValid(String value, ConstraintValidatorContext context) {
		  if (value == null) {
				return true; // 如果值为null，默认验证通过，可以使用@NotNull注解来强制非空
		  }
		  return allowedValues.contains(value);
	 }
}
