package com.example.ae.services;

import com.example.ae.models.User;
import com.example.ae.repositories.Base.BaseRepoInterface;
import com.example.ae.repositories.JPAUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("userJpa")
public class JPAUserServices implements BaseRepoInterface<User> {

    @Autowired
    private JPAUserRepo jpaUserRepo;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Override
    public User save(User object) {
        object.setPassword(passwordEncoder.encode(object.getPassword()));
        return jpaUserRepo.save(object);
    }

    public Optional<User> getUserByUserName(String name){
        return jpaUserRepo.findByName(name);
    }

    @Override
    public List<User> findAll() {
        return jpaUserRepo.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return jpaUserRepo.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        jpaUserRepo.deleteById(id);
    }

    @Override
    public User updateById(Long id, User objectDetails) {
        Optional<User> oldUser = jpaUserRepo.findById(id);
        if (oldUser.isPresent()) {
            User updatedUser = oldUser.get();
            if (objectDetails.getName() != null) updatedUser.setName(objectDetails.getName());
            if (objectDetails.getPassword() != null) updatedUser.setPassword(passwordEncoder.encode(objectDetails.getPassword()));

            return jpaUserRepo.save(updatedUser);
        }
        return null;
    }
}
