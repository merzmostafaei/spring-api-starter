package com.merzmostafaei.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(StoreApplication.class, args);
    }

    //--Creating your First-API->UserController

    //--Calling APIS with Postman

    //--Creating Dynamic Routes-->getUser in UserController.java (find user by fetching the ID)

    //--Setting HTTP Status Codes ->use ResponseEntityClass ->in UserCondtrollClass
    //--DTO (DataTransferObject)when use UserDto must map it to -> User Entity (use in UserController)

    //--Mapping Objects Using Mapstruct ->Create Package of Mapper and use UserMapper Class,and then change the UserController

    //--Customizing Response Data -> in UserDto and UserMapper

}
