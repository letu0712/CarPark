package com.example.carpark.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice       //Cho phep tra ve json
public class CustomExceptionHandler {
    @ExceptionHandler(NotFoundException.class)  //Chỉ rõ method này xử l exception nào
    @ResponseStatus(HttpStatus.NOT_FOUND)       // Định nghĩa HttpStatus trả về cho người dùng
    public ErrorResponse handlerNotFoundException(NotFoundException ex, WebRequest request){
        return new ErrorResponse(HttpStatus.NOT_FOUND, ex.getMessage());
    }


    @ExceptionHandler(DuplicateRecordException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handlerDuplicateRecordException(DuplicateRecordException ex, WebRequest request){
        return new ErrorResponse(HttpStatus.BAD_REQUEST, ex.getMessage());
    }

}
