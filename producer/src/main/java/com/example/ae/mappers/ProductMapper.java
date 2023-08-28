package com.example.ae.mappers;

import com.example.ae.models.Product;
import com.example.ae.pojo.ProductPOJO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductMapper MAPPER = Mappers.getMapper(ProductMapper.class);
    ProductPOJO mapToProductPOJO(Product product);
    Product mapToProduct(ProductPOJO productPOJO);

}
