package com.maxwell.projetoapinuvem.controller.exception;

import com.maxwell.projetoapinuvem.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

//METODOS PARA EXCEPTIONS DE ERROS
@RestControllerAdvice
public class GlobalExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handlebusinessException(IllegalArgumentException businessException){
        return new ResponseEntity<>(businessException.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
        }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handlenotFoundException(IllegalArgumentException notFoundException){
        return new ResponseEntity<>("ID não encontrado", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<String> handleUnexpectedException(IllegalArgumentException unexpectedException){
        var message = "ERRO NO SERVIDOR, ANALISE OS LOGS.";
        logger.error(message, unexpectedException);
        return new ResponseEntity<>("ERRO NO SERVIDOR", HttpStatus.INTERNAL_SERVER_ERROR);
    }





    }



