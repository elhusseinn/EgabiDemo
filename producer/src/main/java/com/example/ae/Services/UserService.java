package com.example.ae.Services;

import com.example.ae.Mappers.UserMapper;
import com.example.ae.Models.Product;
import com.example.ae.Models.User;
import com.example.ae.POJO.ProductPOJO;
import com.example.ae.POJO.UserPOJO;
import com.example.ae.Repositories.Base.BaseRepoInterface;
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
