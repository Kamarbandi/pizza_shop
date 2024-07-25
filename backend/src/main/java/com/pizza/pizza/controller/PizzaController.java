package com.pizza.pizza.controller;

import com.pizza.pizza.exception.PizzaNotFoundException;
import com.pizza.pizza.service.PizzaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/data")
@RequiredArgsConstructor
public class PizzaController {
    private final PizzaService pizzaService;

    @GetMapping("/pizzas")
    public ResponseEntity getAllPizzas(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "4") int limit,
            @RequestParam(defaultValue = "rating") String sortBy,
            @RequestParam(defaultValue = "asc") String order,
            @RequestParam(required = false) String search,
            @RequestParam(required = false) Integer category
    ) {
        return ResponseEntity.ok(pizzaService.getAllPizzas(page, limit, sortBy, order, search, category));
    }

    @GetMapping("/pizza/{id}")
    public ResponseEntity getPizza(@PathVariable Long id) throws PizzaNotFoundException {
        return ResponseEntity.ok(pizzaService.getPizzaById(id));
    }

    @GetMapping("/total_price")
    public ResponseEntity getSumOfAllPizzas()
    {
        return ResponseEntity.ok(pizzaService.getSumOfAllPizzas());
    }
}
