package com.xinerji.tmaxxfinrest.expections;

import com.xinerji.tmaxxfindto.common.ApiError;
import com.xinerji.tmaxxfinrest.expections.BadRequestException;
import com.xinerji.tmaxxfinrest.expections.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;
import java.sql.Timestamp;
import java.util.List;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
@Slf4j
public class RestExceptionHandler  {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handleResourceNotFound(
            ResourceNotFoundException ex,  WebRequest request) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND.value(),
                ex.getMessage(), timestamp, HttpStatus.NOT_FOUND.getReasonPhrase());
        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Object> handleBadRequest(
            BadRequestException ex, WebRequest request) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST.value(),
                ex.getMessage(), timestamp, HttpStatus.BAD_REQUEST.getReasonPhrase());
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<Object> handleConflict(
            BadRequestException ex, WebRequest request) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        ApiError apiError = new ApiError(HttpStatus.CONFLICT.value(),
                ex.getMessage(), timestamp, HttpStatus.CONFLICT.getReasonPhrase());
        return new ResponseEntity<>(apiError, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(AppException.class)
    public ResponseEntity<Object> handleAppException(
            BadRequestException ex, WebRequest request) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                ex.getMessage(), timestamp, HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        return new ResponseEntity<>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers,
            HttpStatus status, WebRequest request) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        List<ObjectError> errors = ex.getBindingResult().getAllErrors();
        String[] messages = new String[errors.size()];
        for (int i=0;i<errors.size();i++){
            messages[i]= errors.get(i).getDefaultMessage();
        }
        ApiError errorDetails = new ApiError(HttpStatus.BAD_REQUEST.value(),
                messages, timestamp, "ARGUMENT_VALIDATION_ERROR");
        return new ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST);
    }
}
