package com.pizza.pizza.model;

import com.pizza.pizza.entity.PizzaTypeEntity;

public class PizzaT {
    private Long id;
    private int type;

    public static PizzaT toModel(PizzaTypeEntity entity) {
        PizzaT model = new PizzaT();
        model.setId(entity.getId());
        model.setType(entity.getType());
        return model;
    }

    public PizzaT() {
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
}
