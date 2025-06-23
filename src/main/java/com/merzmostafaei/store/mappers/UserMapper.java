package com.merzmostafaei.store.mappers;

import com.merzmostafaei.store.dtos.UserDto;
import com.merzmostafaei.store.entities.User;
import org.mapstruct.Mapper;

//Mapping Objects Using Mapstruct
@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);
}
