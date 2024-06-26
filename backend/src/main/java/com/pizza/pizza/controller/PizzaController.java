package com.pizza.pizza.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/data")
public class PizzaController {

    @GetMapping("/pizzas")
    public ResponseEntity getAllPizzas() {
        try {
            return ResponseEntity.ok("All pizzas");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Server is not working");
        }
    }
}
