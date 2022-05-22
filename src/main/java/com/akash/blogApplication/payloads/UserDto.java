package com.akash.blogApplication.payloads;

//for data transfer of user-entity as we don't want to directly pass the entity


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
//We use for Data Transfers, we directly expose it.

public class UserDto {
    private int id;


    private String name;


    private String password;
    private String about;
    private String email;
}
