package com.akash.blogApplication.exceptions;

import com.akash.blogApplication.payloads.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException exception)
    {
        String message= exception.getMessage();
        Date date= new Date();
        ApiResponse apiResponse= new ApiResponse(message,false,date.getTime());
        return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.NOT_FOUND);

    }
    @ExceptionHandler
    public ResponseEntity<Map<String, String>> handleMethodArgNotValidException(MethodArgumentNotValidException exception)
    {
        Map<String, String > errorMessages= new HashMap<>();
        exception.getBindingResult().getAllErrors().forEach(error->{
           String fieldName= ((FieldError)error).getField();
           String message= error.getDefaultMessage();
           errorMessages.put(fieldName,message);
        });


        return new ResponseEntity<Map<String,String>>(errorMessages,HttpStatus.BAD_REQUEST);
    }
}
