package com.pizza.pizza.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "pizzas")
public class PizzaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String img_url;
    private String title;
    private int price;
    private int category;
    private int rating;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pizza")
    private List<PizzaTypeEntity> types;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pizza")
    private List<PizzaSizeEntity> sizes;

    public PizzaEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
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

    public List<PizzaTypeEntity> getTypes() {
        return types;
    }

    public void setTypes(List<PizzaTypeEntity> types) {
        this.types = types;
    }

    public List<PizzaSizeEntity> getSizes() {
        return sizes;
    }

    public void setSizes(List<PizzaSizeEntity> sizes) {
        this.sizes = sizes;
    }
}
