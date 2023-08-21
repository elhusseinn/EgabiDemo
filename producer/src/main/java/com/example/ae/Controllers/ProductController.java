package com.example.ae.Controllers;

import com.example.ae.Models.Product;
import com.example.ae.POJO.ProductPOJO;
import com.example.ae.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping
    public ProductPOJO createProduct(@RequestBody ProductPOJO productPOJO){
        return productService.createProduct(productPOJO);
    }

    @GetMapping
    public List<ProductPOJO> getALlProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Optional<ProductPOJO> getProductByID(@PathVariable Long id){
        return productService.getProductByID(id);
    }

    @PutMapping("/{id}")
    public ProductPOJO updateProduct(@PathVariable Long id, @RequestBody ProductPOJO productDetails){
        return productService.updateProduct(id, productDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
    }

}
