package com.spring.taskschedule.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IdNotFoundException.class)
    public ResponseEntity<ApiResponse<?>> handleIdNotFoundException(IdNotFoundException idNotFoundException){
        ApiResponse<Object> errorResponse = ApiResponse.error(HttpStatus.NOT_FOUND, idNotFoundException.getErrorMessage());
        return new ResponseEntity<ApiResponse<?>>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PasswordMismatchException.class)
    public ResponseEntity<ApiResponse<?>> handlePasswordMismatchException(PasswordMismatchException passwordMismatchException){
        ApiResponse<Object> errorResponse = ApiResponse.error(HttpStatus.BAD_REQUEST, passwordMismatchException.getErrorMessage());
        return new ResponseEntity<ApiResponse<?>>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IdAndPasswordMismatchException.class)
    public ResponseEntity<ApiResponse<?>> handleIdAndPasswordMismatchException(IdAndPasswordMismatchException idAndPasswordMismatchException){
        ApiResponse<Object> errorResponse = ApiResponse.error(HttpStatus.UNAUTHORIZED, idAndPasswordMismatchException.getErrorMessage());
        return new ResponseEntity<ApiResponse<?>>(errorResponse, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<?>> handleMethodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException){
        String errorMessage = "";
        BindingResult bindingResult = methodArgumentNotValidException.getBindingResult();
        for (FieldError fieldError : bindingResult.getFieldErrors()){
            errorMessage = errorMessage + fieldError.getDefaultMessage();
        }
        ApiResponse<Object> errorResponse = ApiResponse.error(HttpStatus.BAD_REQUEST, errorMessage);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
