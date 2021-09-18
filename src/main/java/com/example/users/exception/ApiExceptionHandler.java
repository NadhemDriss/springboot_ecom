package com.example.users.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<FieldError> fieldErrorsList = ex.getBindingResult().getFieldErrors();
        ValidationError validationError = new ValidationError();
        for(FieldError fieldError: fieldErrorsList) {
            String error = fieldError.getDefaultMessage();
            validationError.addError(error);
        }

        return new ResponseEntity<>(validationError, HttpStatus.BAD_REQUEST);
    }
}
