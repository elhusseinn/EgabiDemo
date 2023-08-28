package com.example.ae.Controllers;


import com.example.ae.Models.User;
import com.example.ae.POJO.UserPOJO;
import com.example.ae.Services.AuthService;
import com.example.ae.Utils.AuthUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthService authService;
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<String> login(@RequestBody UserPOJO userPOJO) throws Exception {
        String token = authService.login(userPOJO);
        return new ResponseEntity<>(token, HttpStatus.OK);
    }
}
