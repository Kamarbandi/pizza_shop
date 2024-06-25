package com.pizza.pizza.service;

import com.pizza.pizza.entity.PostEntity;
import com.pizza.pizza.entity.UserEntity;
import com.pizza.pizza.model.Post;
import com.pizza.pizza.repo.PostRepo;
import com.pizza.pizza.repo.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    private PostRepo postRepo;
    private UserRepository userRepo;

    public PostService(PostRepo postRepo, UserRepository userRepo) {
        this.postRepo = postRepo;
        this.userRepo = userRepo;
    }

    public Post createPost(PostEntity post, Long userId) {
        UserEntity user = userRepo.findById(userId).get();
        post.setUser(user);
        return Post.toModel(postRepo.save(post));
    }

    public Post complete(Long id) {
        PostEntity post = postRepo.findById(id).get();
        post.setCompleted(!post.getCompleted());
        return Post.toModel(postRepo.save(post));
    }
}
