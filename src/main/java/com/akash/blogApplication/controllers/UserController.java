package com.akash.blogApplication.controllers;

import com.akash.blogApplication.entities.User;
import com.akash.blogApplication.payloads.UserDto;
import com.akash.blogApplication.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    //POST - create user
    @PostMapping("/")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto)
    {
        UserDto createdUserDto= this.userService.createUser(userDto);
        return new ResponseEntity<>(createdUserDto, HttpStatus.CREATED);
    }

    //PUT
    @PutMapping("/{userId}")
    public ResponseEntity<UserDto>  updateUser(@RequestBody UserDto userDto,@PathVariable("userId") Integer userId)
    {
        UserDto updatedUserDto= this.userService.updateUser(userDto,userId);
        return  ResponseEntity.ok(userDto);
    }
    //DELETE

    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUser( @PathVariable("userId") Integer userId)
    {
        this.userService.deleteUser(userId);
        return new ResponseEntity<>(Map.of("message:","User deleted successfully"), HttpStatus.OK);
    }


    // GET ALL USERS
    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getAllUsers()
    {
       List<UserDto> allUsers=  this.userService.getAllUsers();
       return new ResponseEntity<>(allUsers,HttpStatus.OK);
    }
    // GET SINGLE USERS
    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getAllUsers(@PathVariable("userId") Integer uId)
    {
        UserDto fetchedUser=  this.userService.getUserById(uId);
        return new ResponseEntity<>(fetchedUser,HttpStatus.OK);
    }
}
