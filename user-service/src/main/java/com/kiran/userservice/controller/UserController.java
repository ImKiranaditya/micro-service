package com.kiran.userservice.controller;

import com.kiran.userservice.entities.User;
import com.kiran.userservice.external.service.AddressServiceExternal;
import com.kiran.userservice.service.UserService;
import com.kiran.userservice.vo.Address;
import com.kiran.userservice.vo.ResponseTemplateVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    public UserService userService;
    @Autowired
    AddressServiceExternal addressServiceExternal;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseTemplateVO getUserById(@PathVariable Long userId) {
        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user = userService.getUserById(userId);
      /*  Address address = restTemplate.getForObject("http://ADDRESS-SERVICE/api/addresses/" + user.getAddressId()
                , Address.class); */

        log.info("********  user.getAddressId() ********"+user.getAddressId());
        Address addressById = addressServiceExternal.getAddressById(user.getAddressId());
        log.info("********  addressId ********"+addressById);
        vo.setUser(user);
        vo.setAddress(addressById);
        return vo;
    }


    @DeleteMapping("/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteUser(@PathVariable Long userId) {
        return userService.deleteUser(userId);
    }
}
