package com.example.ae.Services;

import com.example.ae.Mappers.ProductMapper;
import com.example.ae.Models.Product;
import com.example.ae.Models.User;
import com.example.ae.POJO.ProductPOJO;
import com.example.ae.Repositories.Base.BaseRepoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    @Qualifier("productJdbc")
    private BaseRepoInterface<Product> baseRepoInterface;
    // create new product
    public ProductPOJO createProduct(ProductPOJO productPOJO){

        Product product =  productMapper.mapToProduct(productPOJO);

        Product createdProduct = (Product) baseRepoInterface.save(product);

        return productMapper.mapToProductPOJO(createdProduct);
    }

    // get all products
    public List<ProductPOJO> getAllProducts(){
        List<ProductPOJO> productPOJOS = new ArrayList<>();
        List<Product> products =  baseRepoInterface.findAll();
        for(Product product:products){
            productPOJOS.add(productMapper.mapToProductPOJO(product));
        }

        return productPOJOS;
    }

    //getProductByID
    public Optional<ProductPOJO> getProductByID(Long id){
        Optional<Product> product =  baseRepoInterface.findById(id);
        return product.map(value -> productMapper.mapToProductPOJO(value));
    }

    public void deleteProduct(Long id){
        baseRepoInterface.deleteById(id);
    }

    public ProductPOJO updateProduct(Long id, ProductPOJO productDetails){

        Optional<Product> oldProduct = baseRepoInterface.findById(id);
        if (oldProduct.isPresent()) {
            Product updatedProject = oldProduct.get();
            if (productDetails.getName() != null) updatedProject.setName(productDetails.getName());
            if (productDetails.getPrice() != null) updatedProject.setPrice(productDetails.getPrice());

            baseRepoInterface.save(updatedProject);
            return productMapper.mapToProductPOJO(updatedProject);

        }
        return null;

    }

}
