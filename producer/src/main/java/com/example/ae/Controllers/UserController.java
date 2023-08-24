package com.example.ae.Controllers;

import com.example.ae.Models.User;
import com.example.ae.POJO.UserPOJO;
import com.example.ae.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.POST)
    public UserPOJO createUser(@RequestBody UserPOJO userPOJO){
        return userService.createUser(userPOJO);
    }
    @RequestMapping(method = RequestMethod.GET)
    public List<UserPOJO> getAllUsers(){return userService.getAllUsers();}

}