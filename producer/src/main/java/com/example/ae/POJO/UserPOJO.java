package com.example.ae.POJO;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    private String password;
}
