package com.example.ae.Repositories;

import com.example.ae.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JPAUserRepo extends JpaRepository<User, Long>{
    Optional<User>findByName(String name);
}
