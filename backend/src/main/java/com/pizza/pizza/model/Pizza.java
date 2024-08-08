package com.pizza.pizza.model;

import com.pizza.pizza.entity.PizzaEntity;

import java.util.List;
import java.util.stream.Collectors;

public class Pizza {
    private Long id;
    private String image_url;
    private String title;
    private int price;
    private int category;
    private int rating;

    private List<PizzaT> pizzaT;

    public Pizza() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public List<PizzaT> getPizzaT() {
        return pizzaT;
    }

    public void setPizzaT(List<PizzaT> pizzaT) {
        this.pizzaT = pizzaT;
    }
}
