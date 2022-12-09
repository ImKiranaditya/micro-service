package com.kiran.userservice.service;

import com.kiran.userservice.entities.User;
import com.kiran.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public UserRepository repository;

    @Override
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> byId = repository.findById(id);
        if (byId.isPresent()) {
            return byId.get();
        } /*else {
           // throw new ResourceNotFoundException("User with id: " + id + " is not found in database ");
        }*/
        return new User();
    }

    @Override
    public User addUser(User user) {
        return repository.save(user);
    }

    @Override
    public User updateUser(User User, Long UserId) {
        return null;
    }

    @Override
    public String deleteUser(Long userId) {
        repository.deleteById(userId);

        return "User with id : "+userId+" is successfully deleted..";
    }
}
