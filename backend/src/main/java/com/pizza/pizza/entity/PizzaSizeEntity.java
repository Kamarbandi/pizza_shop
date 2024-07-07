package com.pizza.pizza.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "sizes")
public class PizzaSizeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int size;

    @ManyToOne
    @JoinColumn(name = "pizza_id")
    @JsonIgnore
    private PizzaEntity pizza;
}
