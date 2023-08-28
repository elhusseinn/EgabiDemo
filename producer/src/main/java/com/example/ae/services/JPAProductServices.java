package com.example.ae.services;

import com.example.ae.models.Product;
import com.example.ae.repositories.Base.BaseRepoInterface;
import com.example.ae.repositories.JPAProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service("productJpa")
public class JPAProductServices implements BaseRepoInterface<Product> {

    @Autowired
    private JPAProductRepo jpaProductRepo;

    @Override
    public Product save(Product object) {
        return jpaProductRepo.save(object);
    }

    @Override
    public List<Product> findAll() {
        return jpaProductRepo.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return jpaProductRepo.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        jpaProductRepo.deleteById(id);
    }

    @Override
    public Product updateById(Long id, Product objectDetails) {
        Optional<Product> oldProduct = jpaProductRepo.findById(id);
        if (oldProduct.isPresent()) {
            Product updatedProduct = oldProduct.get();
            if (objectDetails.getName() != null) updatedProduct.setName(objectDetails.getName());
            if (objectDetails.getPrice() != null) updatedProduct.setPrice(objectDetails.getPrice());

            return jpaProductRepo.save(updatedProduct);
        }
        return null;
    }
}
