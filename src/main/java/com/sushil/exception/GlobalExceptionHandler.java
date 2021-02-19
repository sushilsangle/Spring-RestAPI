package com.sushil.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.handler.ResponseStatusExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request){
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
       // ErrorResponse error = new ErrorResponse("Server Error",details);
        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);

    }
    @ExceptionHandler(RecordNotFoundException.class)
    public final ResponseEntity<Object> handleUserNotFoundException(RecordNotFoundException ex,WebRequest request)
    {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
       // ErrorResponse error = new ErrorResponse("Record Not Found",details);
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
//    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders header,HttpStatus status,WebRequest request)
//    {
//        List<String> details = new ArrayList<>();
//        for (ObjectError error :ex.getBindingResult().getAllErrors())
//        {
//            details.add(error.getDefaultMessage());
//        }
//        ErrorResponse error = new ErrorResponse("Validation Failed",details);
//        return new ResponseEntity(error,HttpStatus.BAD_REQUEST);
//    }

}
