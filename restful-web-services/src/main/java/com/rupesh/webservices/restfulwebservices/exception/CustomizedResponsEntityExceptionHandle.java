package com.rupesh.webservices.restfulwebservices.exception;

import java.net.http.HttpHeaders;
import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.rupesh.webservices.restfulwebservices.User.UserNotFoundException;

@ControllerAdvice
public class CustomizedResponsEntityExceptionHandle extends ResponseEntityExceptionHandler{

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorDetails> handleAllExceptions(Exception ex, WebRequest request) throws Exception {
        ErrorDetails errorDetails= new ErrorDetails(LocalDate.now(),
                                     ex.getMessage(),
                                     request.getDescription(false));

        return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<ErrorDetails> handleUserNotFoundException(Exception ex, WebRequest request) throws Exception {
        ErrorDetails errorDetails= new ErrorDetails(LocalDate.now(),
                                     ex.getMessage(),
                                     request.getDescription(false));

        return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.NOT_FOUND);
    }
   
    protected ResponseEntity<ErrorDetails> handleMethodArgumentNotValid(
    MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request){

                ErrorDetails errorDetails= new ErrorDetails(LocalDate.now(),
                ex.getMessage(),
                request.getDescription(false));


            return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.BAD_REQUEST);
	}
}

