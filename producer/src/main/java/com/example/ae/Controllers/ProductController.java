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

    @RequestMapping(method = RequestMethod.POST)
    public ProductPOJO createProduct(@RequestBody ProductPOJO productPOJO){
        return productService.createProduct(productPOJO);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<ProductPOJO> getALlProducts(){
        return productService.getAllProducts();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<ProductPOJO> getProductByID(@PathVariable Long id){
        return productService.getProductByID(id);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public ProductPOJO updateProduct(@PathVariable Long id, @RequestBody ProductPOJO productDetails){
        return productService.updateProduct(id, productDetails);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
    }

}
