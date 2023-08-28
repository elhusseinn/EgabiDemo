package com.example.ae.services;

import com.example.ae.mappers.UserMapper;
import com.example.ae.models.User;
import com.example.ae.pojo.UserPOJO;
import com.example.ae.repositories.Base.BaseRepoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    @Qualifier("userJpa")
    private BaseRepoInterface<User> baseRepoInterface;

    public UserPOJO createUser (UserPOJO userPOJO){
        User user = userMapper.mapToUser(userPOJO);
        User createdUser = (User) baseRepoInterface.save(user);
        return userMapper.mapToUserPOJO(createdUser);
    }
    public List<UserPOJO> getAllUsers(){
        List<UserPOJO> userPOJOS = new ArrayList<>();
        List<User> users =  baseRepoInterface.findAll();
        for(User user:users){
            userPOJOS.add(userMapper.mapToUserPOJO(user));
        }

        return userPOJOS;
    }
}
