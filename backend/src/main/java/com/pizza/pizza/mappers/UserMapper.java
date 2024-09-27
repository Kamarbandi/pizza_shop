package com.pizza.pizza.mappers;


import com.pizza.pizza.dtos.UserDto;
import com.pizza.pizza.entity.SignUpDto;
import com.pizza.pizza.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toUserDto(UserEntity user);

    @Mapping(target = "password", ignore = true)
    UserEntity signUpToUser(SignUpDto signUpDto);

}
