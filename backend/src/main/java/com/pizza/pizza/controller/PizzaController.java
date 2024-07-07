package com.pizza.pizza.controller;

import com.pizza.pizza.entity.PizzaEntity;
import com.pizza.pizza.service.PizzaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/data")
public class PizzaController {
    private PizzaService pizzaService;

    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @GetMapping("/pizzas")
    public ResponseEntity getAllPizzas() {
        return ResponseEntity.ok(pizzaService.getAllPizzas());
    }
}
