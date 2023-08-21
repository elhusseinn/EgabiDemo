package com.example.Services;


import com.example.POJO.ProductPOJO;
import com.example.Services.Base.BaseService;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

@Service
public class GetProductService extends BaseService {

    public ProductPOJO[] getAllProduct()
    {
        return (ProductPOJO[]) callService(ProductPOJO[].class, null);
    }


    @Override
    public String getUrl() {
        return "http://localhost:8081/products";
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.GET;
    }
}
