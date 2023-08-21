package com.example.ae.Repositories;

import com.example.ae.Models.Product;
import com.example.ae.Repositories.Base.BaseRepoInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JPAProductRepo extends JpaRepository<Product, Long>{

}
