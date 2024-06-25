package com.pizza.pizza.controller;

import com.pizza.pizza.entity.PostEntity;
import com.pizza.pizza.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
public class PostController {
    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity createPost(@RequestBody PostEntity post, @RequestParam Long userId) {
        try {
            return ResponseEntity.ok(postService.createPost(post, userId));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Server is not working");
        }
    }

    @PutMapping
    public ResponseEntity createPost(@RequestParam Long userId) {
        try {
            return ResponseEntity.ok(postService.complete(userId));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Server is not working");
        }
    }
}
