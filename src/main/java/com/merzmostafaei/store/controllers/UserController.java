package com.merzmostafaei.store.controllers;

import com.merzmostafaei.store.dtos.RegisterUserRequest;
import com.merzmostafaei.store.dtos.UpdateUserRequest;
import com.merzmostafaei.store.dtos.UserDto;
import com.merzmostafaei.store.entities.User;
import com.merzmostafaei.store.mappers.UserMapper;
import com.merzmostafaei.store.repositories.UserRepository;
import jakarta.websocket.server.ServerEndpoint;
import lombok.AllArgsConstructor;
import org.mapstruct.control.MappingControl;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Set;


//--Creating your First-API

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @GetMapping
    //DTO (DataTransferObject)when use UserDto must map it to -> User Entity
    //--Extracting Query Parameters @RequestParam(required = false //not give badrequest ,defaultValue = ""to not give null error,name ="sort" best practice if we change queryname
    //--Extractiong Request Headers -> @RequestHeader (name = "x-auth-token")String autuToken
    public Iterable<UserDto> getAllUsers(
            //@RequestHeader (name = "x-auth-token",required = false)String autuToken,
            @RequestParam(required = false,defaultValue = "",name ="sort") String sortBye
    ){
        //--Extractiong Request Headers see
       // System.out.println(autuToken);

        //--Extracting Query Parameters
            //--valid value
                //--for ErrorStatus 500
        if (!Set.of("name","email").contains(sortBye))
            //set the defult value
            sortBye = "name";

//        return userRepository.findAll()
//                .stream()
//                .map(user -> new UserDto(user.getId(), user.getName(),user.getEmail()))
//                .toList();
        //Mapping Objects Using Mapstruct
        return userRepository.findAll(Sort.by(sortBye))//--Extracting Query Parameters Sort,by
                .stream()
                .map(userMapper::toDto)
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

        //Mapping Objects Using Mapstruct
                //we don't need to create userDtro
        //var userDto = new UserDto(user.getId(), user.getName(), user.getEmail());
        //return ResponseEntity.ok(userDto);
        return ResponseEntity.ok(userMapper.toDto(user));
    }

    //--Extracting Request Body
//    @PostMapping
//    public UserDto createUser(@RequestBody UserDto data){
//        return data;
//    }
    //--Create Resources
    // set the status to 201 mean create in UserController ->ResponseEntity
    @PostMapping
    public ResponseEntity<UserDto> createUser(
            @RequestBody RegisterUserRequest request,
            UriComponentsBuilder uriBuilder
    ){
        var user = userMapper.toEntity(request);
        //System.out.println(user);
        //save user
        userRepository.save(user);
        //map it to dto
        var userDto = userMapper.toDto(user);
        //201 status ,for Return ResponseEntity.created (URL location) -> as parameter UriComponentsBuilder uriBuilder
        //201 status, build URL Location -> we set the new location of header users/6 ->id new user
        var uri = uriBuilder.path("/users/{id}").buildAndExpand(userDto.getId()).toUri();
        return ResponseEntity.created(uri).body(userDto);
    }
    //--UpdatingResources
    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(
            @PathVariable(name="id") Long id,
            @RequestBody UpdateUserRequest request){
            //we should validate this Resourse user exist if not retur 404 erro
            var user = userRepository.findById(id).orElse(null);
            if(user == null){
                return ResponseEntity.notFound().build();
            }

            //add the method to update user with dto in userDto -> make method in UserMapper
            userMapper.update(request,user);
            //save user
            userRepository.save(user);
            //we mapped it to dto and return the response
        return ResponseEntity.ok(userMapper.toDto(user));

    }
    //DeletingResources
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        var user = userRepository.findById(id).orElse(null);
        if(user == null){
            return ResponseEntity.notFound().build();
        }
        userRepository.delete(user);
        return ResponseEntity.noContent().build();
    }

}




