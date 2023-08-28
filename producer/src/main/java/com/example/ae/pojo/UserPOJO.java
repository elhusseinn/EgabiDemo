package com.example.ae.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserPOJO {
    @Override
    public String toString() {
        return "UserPOJO{" +
                "name='" + name + '\'' +
                '}';
    }

    private String name;

    private String password;
}
