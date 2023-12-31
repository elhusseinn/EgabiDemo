package com.example.ae.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogPOJO {
    private String method;
    private LocalDateTime time;
    private String requestURI;
    private Object[] args;


}
