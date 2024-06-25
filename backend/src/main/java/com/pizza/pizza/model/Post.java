package com.pizza.pizza.model;

import com.pizza.pizza.entity.PostEntity;

public class Post {
    private Long id;
    private String title;
    private Boolean completed;

    public static Post toModel(PostEntity entity) {
        Post model = new Post();
        model.setId(entity.getId());
        model.setCompleted(entity.getCompleted());
        model.setTitle(entity.getTitle());
        return model;
    }

    public Post() {
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

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}
