package com.pizza.pizza.repo;

import com.pizza.pizza.entity.PizzaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaRepo extends JpaRepository<PizzaEntity, Long> {
}
