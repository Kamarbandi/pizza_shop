package com.pizza.pizza.service;

import com.pizza.pizza.entity.UserEntity;
import com.pizza.pizza.exception.UserAlreadyExistException;
import com.pizza.pizza.exception.UserNotFoundException;
import com.pizza.pizza.model.User;
import com.pizza.pizza.repo.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity registerUser(UserEntity user) throws UserAlreadyExistException {
        if (userRepository.findByUsername(user.getUsername()) != null) {
            throw new UserAlreadyExistException(user.getUsername() +  " already exists");
        }

        return userRepository.save(user);
    }

    public User getUser(Long id) throws UserNotFoundException {
        UserEntity user = userRepository.findById(id).get();
        if (user == null) {
            throw new UserNotFoundException("User don't found");
        }

        return User.toModel(user);
    }

    public Long delete(Long id) {
        userRepository.deleteById(id);
        return id;
    }
}
