package com.example.Services;

import com.example.POJO.ProductPOJO;
import com.example.Services.Base.BaseService;
import org.springframework.http.*;
import org.springframework.stereotype.Service;

@Service
public class CreateProductService extends BaseService {

    public ProductPOJO createProduct(ProductPOJO productPOJO){
        return (ProductPOJO) callService(ProductPOJO.class, productPOJO);
    }


    @Override
    public String getUrl() {
        return "http://localhost:8081/products";
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.POST;
    }
}
