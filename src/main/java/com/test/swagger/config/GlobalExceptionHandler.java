package com.test.swagger.config;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * @Desc GlobalExceptionHandler
 * @Author LiuYunLong
 */
@RestControllerAdvice
public class GlobalExceptionHandler {


	 @ExceptionHandler(MethodArgumentNotValidException.class)
	 public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
		  Map<String, String> errors = new HashMap<>();
		  ex.getBindingResult().getAllErrors().forEach((error) -> {
				String fieldName = ((FieldError) error).getField();
				String errorMessage = error.getDefaultMessage();
				errors.put(fieldName, errorMessage);
		  });
		  return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	 }

	 @ExceptionHandler(MissingPathVariableException.class)
	 public ResponseEntity<Map<String, String>> handleMissingPathVariableException(MissingPathVariableException ex) {
		  Map<String, String> errors = new HashMap<>();
		  errors.put(ex.getVariableName(), "路径变量 " + ex.getVariableName() + " 缺失");
		  return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	 }

	 @ExceptionHandler(TypeMismatchException.class)
	 public ResponseEntity<Map<String, String>> handleTypeMismatchException(TypeMismatchException ex) {
		  Map<String, String> errorResponse = new HashMap<>();
		  errorResponse.put("error", "类型不匹配: " + ex.getPropertyName() + " 应该是 " + ex.getRequiredType().getSimpleName());
		  return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	 }


	 // 处理其他异常
	 @ExceptionHandler(Exception.class)
	 public ResponseEntity<Map<String, String>> handleAllExceptions(Exception ex) {
		  Map<String, String> errors = new HashMap<>();
		  errors.put("error", ex.getMessage());
		  return new ResponseEntity<>(errors, HttpStatus.INTERNAL_SERVER_ERROR);
	 }

}
