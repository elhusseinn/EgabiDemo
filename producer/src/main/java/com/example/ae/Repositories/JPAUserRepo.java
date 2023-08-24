package com.example.ae.Repositories;

import com.example.ae.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JPAUserRepo extends JpaRepository<User, Long>{
}
