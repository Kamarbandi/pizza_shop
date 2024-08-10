package com.pizza.pizza.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class PizzaResponseDTO {
    private List<PizzaDTO> pizzas;
    private int totalPages;

    public PizzaResponseDTO(List<PizzaDTO> pizzas, int totalPages) {
        this.pizzas = pizzas;
        this.totalPages = totalPages;
    }
}
