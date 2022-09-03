package com.gitjupalza.domain.chemy.advice;

import com.gitjupalza.domain.chemy.controller.ChemyController;
import com.gitjupalza.domain.chemy.exception.ChemyNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackageClasses = ChemyController.class)
public class ChemyAdvice {
    @ExceptionHandler(ChemyNotFoundException.class)
    public ResponseEntity<?> handle() {
        return ResponseEntity.notFound().build();
    }
}
