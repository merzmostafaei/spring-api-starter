package com.merzmostafaei.store.mappers;

import com.merzmostafaei.store.dtos.UserDto;
import com.merzmostafaei.store.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

//Mapping Objects Using Mapstruct
@Mapper(componentModel = "spring")
public interface UserMapper {
    //Customizing Response Data -> for LocalDateField in UserDto
    //@Mapping(target = "createAt", expression = "java(java.time.LocalDateTime.now())")
    UserDto toDto(User user);
}
