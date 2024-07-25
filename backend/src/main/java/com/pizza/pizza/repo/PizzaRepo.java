package com.pizza.pizza.repo;

import com.pizza.pizza.entity.PizzaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaRepo extends JpaRepository<PizzaEntity, Long> {
    Page<PizzaEntity> findByTitleContainingIgnoreCase(String title, Pageable pageable);
    Page<PizzaEntity> findByCategory(Integer category, Pageable pageable);
    Page<PizzaEntity> findByTitleContainingIgnoreCaseAndCategory(String title, Integer category, Pageable pageable);
}
