package com.example.Controllers;


import com.example.Factories.ProductCRUDFactory;
import com.example.POJO.ProductPOJO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class WebServiceConsumerController{
    @Autowired
    ProductCRUDFactory productCRUDFactory;

    @GetMapping("/template/products")
    public ResponseEntity<ProductPOJO[]> getAllProducts(){
        return ResponseEntity.ok(productCRUDFactory.getProductService.getAllProduct());

    }

    @PostMapping("/template/products")
    public ResponseEntity<ProductPOJO> createProduct(@RequestBody ProductPOJO productPOJO){

        return ResponseEntity.ok(productCRUDFactory.createProductService.createProduct(productPOJO));
    }



}
