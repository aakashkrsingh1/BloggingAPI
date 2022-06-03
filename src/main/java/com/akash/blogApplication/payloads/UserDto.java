package com.akash.blogApplication.payloads;

//for data transfer of user-entity as we don't want to directly pass the entity


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@NoArgsConstructor
@Getter
@Setter
//We use for Data Transfers, we directly expose it.

public class UserDto {
    private int id;

    @NotEmpty
    @Size(min=4,message = "User name must have minimum of 4 characters.")
    private String name;

    @NotEmpty
    @Size(min=3,max=10, message = "Password must be minimum of  3 characters and maximum of 10 chars!")
    private String password;

    @NotEmpty(message = "About cannot be empty.")
    private String about;

    @Email(message = "Email address is not valid.")
    private String email;
}
