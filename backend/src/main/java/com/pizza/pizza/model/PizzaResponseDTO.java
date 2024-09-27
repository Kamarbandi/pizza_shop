package com.pizza.pizza.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@RequiredArgsConstructor
public class PizzaResponseDTO {
    private final List<PizzaDTO> pizzas;
    private final int totalPages;
}
