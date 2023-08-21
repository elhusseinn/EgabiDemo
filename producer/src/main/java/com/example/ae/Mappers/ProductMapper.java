package com.example.ae.Mappers;

import com.example.ae.Models.Product;
import com.example.ae.POJO.ProductPOJO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductMapper MAPPER = Mappers.getMapper(ProductMapper.class);
    ProductPOJO mapToProductPOJO(Product product);
    Product mapToProduct(ProductPOJO productPOJO);

}
