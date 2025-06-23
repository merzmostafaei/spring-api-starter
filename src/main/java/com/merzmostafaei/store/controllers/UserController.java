package com.merzmostafaei.store.controllers;

import com.merzmostafaei.store.dtos.UserDto;
import com.merzmostafaei.store.entities.User;
import com.merzmostafaei.store.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


//--Creating your First-API

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserRepository userRepository;

    @GetMapping
    //DTO (DataTransferObject)when use UserDto must map it to -> User Entity
    public Iterable<UserDto> getAllUsers(){
        return userRepository.findAll()
                .stream()
                .map(user -> new UserDto(user.getId(), user.getName(),user.getEmail()))
                .toList();
    }
    //Setting HTTP Status Codes ->use ResponseEntityClass
    //DTO (DataTransferObject)when use UserDto must map it to -> User Entity

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable Long id){
        var user = userRepository.findById(id).orElse(null);
        if(user == null){
            //return new ResponseEntity<>(HttpStatus.NOT_FOUND); -> but we use static factory method of ResponseEntityClass because is better way
            return ResponseEntity.notFound().build();
        }
        //return new ResponseEntity<>(user,HttpStatus.OK); -> OR use Static Factory Method
        //DTO (DataTransferObject)when use UserDto must map it to -> User Entity

        var userDto = new UserDto(user.getId(), user.getName(), user.getEmail());
        return ResponseEntity.ok(userDto);
    }


}




