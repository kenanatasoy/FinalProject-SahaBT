package com.example.bookstoremicroservice.sale.controller.handler;

import com.example.bookstoremicroservice.sale.dto.error.ErrorResponse;
import com.example.sale.application.business.exception.ExistingSaleException;
import com.example.sale.application.business.exception.SaleNotFoundException;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.MethodArgumentNotValidException;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

@RestControllerAdvice
public class RestControllerErrorHandler {

    @ExceptionHandler(SaleNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleCustomerNotFoundException(SaleNotFoundException e) {
        return new ErrorResponse("Customer Rest API", e.getMessage());
    }

    @ExceptionHandler(ExistingSaleException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleCustomerAlreadyExistException(ExistingSaleException e) {
        return new ErrorResponse("Customer Rest API", e.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    public ErrorResponse handleRuntimeException(RuntimeException e) {
        return new ErrorResponse("Application", e.getMessage());
    }

    @ExceptionHandler(ExpiredJwtException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ErrorResponse handleExpiredJwtException(ExpiredJwtException e) {
        return new ErrorResponse("Security", e.getMessage());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleConstraintViolationException(ConstraintViolationException e) {
        var message = e.getConstraintViolations().stream().map(ConstraintViolation::getMessage).toList().toString();
        return new ErrorResponse("Validation", message);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        var message = e.getAllErrors().stream().map(ObjectError::getDefaultMessage).toList().toString();
        return new ErrorResponse("Validation", message);
    }

}
