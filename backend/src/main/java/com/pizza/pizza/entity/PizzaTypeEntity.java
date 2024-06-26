package com.pizza.pizza.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "types")
public class PizzaTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int type;

    @ManyToOne
    @JoinColumn(name = "pizza_id")
    private PizzaEntity pizza;

    public PizzaTypeEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public PizzaEntity getPizza() {
        return pizza;
    }

    public void setPizza(PizzaEntity pizza) {
        this.pizza = pizza;
    }
}
