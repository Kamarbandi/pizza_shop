package com.pizza.pizza.model;

import com.pizza.pizza.entity.UserEntity;

import java.util.List;
import java.util.stream.Collectors;

public class User {
    private Long id;
    private String username;
    private List<Post> posts;

    public static User toModel(UserEntity entity) {
        User model = new User();
        model.setId(entity.getId());
        model.setUsername(entity.getUsername());
        model.setPosts(
                entity.getPosts().stream().map(Post::toModel).collect(Collectors.toList())
        );

        return model;
    }

    public Long getId() {
        return id;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
