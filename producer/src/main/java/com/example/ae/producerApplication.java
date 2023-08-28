package com.example.ae;

import com.example.ae.Models.User;
import com.example.ae.Repositories.Base.BaseRepoInterface;
import com.example.ae.Repositories.JPAUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@SpringBootApplication
public class producerApplication {

    @Autowired
    JPAUserRepo userRepo;

    @Bean
    public PasswordEncoder encode(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    UserDetailsService userDetailsService(){
        return username-> userRepo.findByName(username).orElseThrow(()->new UsernameNotFoundException("user doesn't exist"));
    }


    public static void main(String[] args) {
        SpringApplication.run(producerApplication.class, args);
    }
}
