package com.pizza.pizza.service;

import com.pizza.pizza.entity.PizzaEntity;
import com.pizza.pizza.repo.PizzaRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class PizzaServiceTest {
    @InjectMocks
    private PizzaService pizzaService;

    @Mock
    private PizzaRepo pizzaRepo;

    @Test
    void sumPriceOfAllPizzas() {
        PizzaEntity pizza1 = new PizzaEntity(1L, "Test1", "Mozarella", 100);
        PizzaEntity pizza2 = new PizzaEntity(2L, "Test2", "Mozarella", 150);

        Mockito.when(pizzaRepo.findAll()).thenReturn(List.of(pizza1, pizza2));

        int totalPriceOfPizzas = pizzaService.getSumOfAllPizzas();
        Assertions.assertEquals(250, totalPriceOfPizzas);
    }
}
