package com.kiran.userservice.service;

import com.kiran.userservice.entities.User;

import java.util.List;

public interface UserService {

    public List<User> getAllUsers();

    public User getUserById(Long id);

    public User addUser(User User);

    public User updateUser(User User,Long UserId);

    public String deleteUser(Long UserId);

}
