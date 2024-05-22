package dev.fincon.finconApi.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import dev.fincon.finconApi.exceptions.ExpenseNotFoundException;

@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    private ResponseEntity<Object> expenseNotFoundHandler(ExpenseNotFoundException expenseNotFoundException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
    }
}