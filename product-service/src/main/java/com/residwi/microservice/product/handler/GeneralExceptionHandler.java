package com.residwi.microservice.product.handler;

import com.residwi.microservice.product.dto.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

@RestControllerAdvice
public class GeneralExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ApiResponse<String> validationHandler(ConstraintViolationException e) {
        return new ApiResponse<>(400, "BAD REQUEST", e.getMessage());
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    ApiResponse<String> notFoundHandler(NotFoundException e) {
        return new ApiResponse<>(400, "NOT FOUND", e.getMessage());
    }

    @ExceptionHandler(UnauthorizedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    ApiResponse<String> unauthorized(UnauthorizedException e) {
        return new ApiResponse<>(401, "UNAUTHORIZED", e.getMessage());
    }

}