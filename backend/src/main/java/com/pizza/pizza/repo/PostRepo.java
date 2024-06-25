package com.pizza.pizza.repo;

import com.pizza.pizza.entity.PostEntity;
import org.springframework.data.repository.CrudRepository;

public interface PostRepo extends CrudRepository<PostEntity, Long> {
}
