package com.pizza.pizza.service;

import com.pizza.pizza.entity.PizzaEntity;
import com.pizza.pizza.exception.PizzaNotFoundException;
import com.pizza.pizza.exception.UserNotFoundException;
import com.pizza.pizza.model.PizzaDTO;
import com.pizza.pizza.repo.PizzaRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.data.domain.Sort;

@Service
public class PizzaService {
    private final PizzaRepo pizzaRepo;

    public PizzaService(PizzaRepo pizzaRepo) {
        this.pizzaRepo = pizzaRepo;
    }

    public List<PizzaDTO> getAllPizzas(int page, int limit, String sortBy, String order, String search, Integer category) {
        Pageable pageable = PageRequest.of(
                page - 1,
                limit,
                order.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending()
        );

        Page<PizzaEntity> pizzaPage;
        if ((search != null && !search.isEmpty()) && category != null) {
            pizzaPage = pizzaRepo.findByTitleContainingIgnoreCaseAndCategory(search, category, pageable);
        } else if (search != null && !search.isEmpty()) {
            pizzaPage = pizzaRepo.findByTitleContainingIgnoreCase(search, pageable);
        } else if (category != null) {
            pizzaPage = pizzaRepo.findByCategory(category, pageable);
        } else {
            pizzaPage = pizzaRepo.findAll(pageable);
        }

        return pizzaPage.stream().map(this::convertToDTO).collect(Collectors.toList());
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


    public PizzaEntity getPizzaById(Long id) throws PizzaNotFoundException {
        return pizzaRepo.findById(id).orElseThrow(() -> new PizzaNotFoundException("Pizza not found with id: " + id));
    }

    public int getSumOfAllPizzas() {
        return pizzaRepo.findAll().stream().mapToInt(PizzaEntity::getPrice).sum();
    }
}
