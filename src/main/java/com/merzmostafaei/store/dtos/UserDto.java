package com.merzmostafaei.store.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class UserDto  {
    //--Customizing Response Data
    //@JsonIgnore -> ignore the fild
    //@JsonProperty("user_id ") -> rename the fild
    private Long id;
    private String name;
    private String email;
    //--Customizing Response Data
    //@JsonInclude(JsonInclude.Include.NON_NULL) -> not gonna show Null Field
    //private String phoneNumber;

    //--Customizing Response Data
    //--to put the some value for this field we go to Our mapper
    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")-->to change the Format Time and Date
    //private LocalDateTime createAt;

}
