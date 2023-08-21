package com.example.ae.POJO;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductPOJO {
    public String name;
    public Double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
