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

    //--Extracting Query Parameters like: http://localhost:8080/users?sort=name   -->on UserController

    //--Building Product EndPoints
                //Build 2 API to fetch Product data
                    //1-fetch all products
                        //--ProductController
                        //--productDto
                        //--ProductController make method for product Dto
                        //ProductRepository
                        //ProductMapper - add metod
                        //ProductController-> method List for Dto-> use Repository -> Map to ProductMapper

                                 //2-Fetch a Single Product By ID
                                        // give the method Prameter in ProductController
                                            //go to Repository and add filter for category
                                            // to Controller validate it with create list
                                            // convert return to list to stream and filter

                        //3- custom query method for join product to category because as defult hibearnate work eager and we don't want fetch all data in product table
                            // make the method in repository for custom query
                            // we use this for not getting multiple query and use query custom and entityGraph

    //--Extractiong Request Headers--> in UserController for giving Custom header For authentication
        // send get request with post man for http://localhost:8080/users?sort=email with header of key x-auth-valu and value 1234


    //--Extracting Request Body - > actual data -> to our Backend use for Create or update Objects
        // send Post method with this raw body to /users
                //{
                    //    "name" : "merz",
                    //    "email": "merz@merz.com"
                    //
                    //} if not have the method you give error of 405
        //add method in UserController

    //--Create Resources -> Create acctual user object with Json
        // we make separate Dto as RegisterUserRequest
        //provide new mapping between dto and user entity -> UserMapper interface
        //back to UserController change Parameter for Method to RegisterUserRequest
        // mapping this object in this method and print it on the terminal
        //add toString method to user entity to see the result in console
        // we save user in userRepository for this method
        // database gonna add the id for this user, we add mapp it to dto and return it with this method
        // set the status to 201 mean create in UserController ->ResponseEntity
        //build URL Location -> we set the new location of header users/6 ->id new user


    //--UpdatingResources
        //in postman change method to Put-> Replace entier Resource or Patch -> for updating one or more Properties -> http://localhost:8080/users/1
            // {
                //  "name":"merz",
                //  "email":"merz@merz.com"
            // }
        //make method for Put in UserController
        //create Seperate Dto UpddateUserRequest
        //use userRepository to find user
        //Change method to ResponseEntity<UserDto> because if user not exict status code must be 404
        //mapping data with usermapper and add method update
        // back to controler call mapper and method provide request and user entity
        //save user by userRepository
        // mapuser to dto and put it in responseentity
        //than with postman update one of the user with just name and email








}
