package com.pizza.pizza.service;

import com.pizza.pizza.entity.PizzaEntity;
import com.pizza.pizza.exception.UserNotFoundException;
import com.pizza.pizza.model.PizzaDTO;
import com.pizza.pizza.repo.PizzaRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PizzaService {
    private final PizzaRepo pizzaRepo;

    public PizzaService(PizzaRepo pizzaRepo) {
        this.pizzaRepo = pizzaRepo;
    }

//    public List<PizzaEntity> getAllPizzas()  {
//        return pizzaRepo.findAll();
//    }

    public List<PizzaDTO> getAllPizzas() {
        return pizzaRepo.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private PizzaDTO convertToDTO(PizzaEntity pizzaEntity) {
        PizzaDTO dto = new PizzaDTO();
        dto.setId(pizzaEntity.getId());
        dto.setImageUrl(pizzaEntity.getImage_url());
        dto.setTitle(pizzaEntity.getTitle());
        dto.setPrice(pizzaEntity.getPrice());
        dto.setCategory(pizzaEntity.getCategory());
        dto.setRating(pizzaEntity.getRating());
        dto.setTypes(pizzaEntity.getTypes().stream().map(type -> type.getType()).collect(Collectors.toList()));
        dto.setSizes(pizzaEntity.getSizes().stream().map(size -> size.getSize()).collect(Collectors.toList()));
        return dto;
    }
}
