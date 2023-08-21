package com.example.Factories;

import com.example.Services.CreateProductService;
import com.example.Services.GetProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductCRUDFactory {
    @Autowired
   public CreateProductService createProductService;
    @Autowired
    public GetProductService getProductService;

}
