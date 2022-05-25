package com.akash.blogApplication.services.impl;

import com.akash.blogApplication.entities.User;
import com.akash.blogApplication.exceptions.ResourceNotFoundException;
import com.akash.blogApplication.payloads.UserDto;
import com.akash.blogApplication.repositories.UserRepo;
import com.akash.blogApplication.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user= this.dtoToUser(userDto);
        User savedUser= this.userRepo.save(user);
        return this.userToDTo(savedUser);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer userId) {
      User user=  this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","id", userId));
      user.setName(userDto.getName());
      user.setEmail(userDto.getEmail());
      user.setPassword(userDto.getPassword());
      user.setAbout(userDto.getAbout());
      User updatedUser = this.userRepo.save(user);
      UserDto updatedUserDto= this.userToDTo(updatedUser);
        return updatedUserDto;
    }

    @Override
    public UserDto getUserById(Integer userId) {
        User user=  this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","id", userId));
        return this.userToDTo(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
       List<User> users= this.userRepo.findAll();

       List<UserDto> usersDto= users.stream().map(this::userToDTo).collect(Collectors.toList());
        return usersDto;
    }

    @Override
    public void deleteUser(Integer userId) {
        User user=  this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","id", userId));
        this.userRepo.delete(user);

    }
    private User dtoToUser(UserDto userDto){
        User user = this.modelMapper.map(userDto,User.class);
//        user.setId(userDto.getId());
//        user.setAbout(userDto.getAbout());
//        user.setName(userDto.getName());
//        user.setEmail(userDto.getEmail());
//        user.setPassword(userDto.getPassword());
        return user;

    }
    private UserDto userToDTo(User user){
        return this.modelMapper.map(user, UserDto.class);

    }
}
