package com.pizza.pizza.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "pizzas")
public class PizzaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String image_url;
    private String title;
    private int price;
    private int category;
    private int rating;

    @OneToMany(mappedBy = "pizza", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PizzaTypeEntity> types;

    @OneToMany(mappedBy = "pizza", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PizzaSizeEntity> sizes;

    public PizzaEntity(Long id, String image_url, String title, int price) {
        this.id = id;
        this.image_url = image_url;
        this.title = title;
        this.price = price;
    }

    public PizzaEntity() {

    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
