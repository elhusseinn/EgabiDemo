package com.example.ae.repositories;

import com.example.ae.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JPAProductRepo extends JpaRepository<Product, Long>{

}
