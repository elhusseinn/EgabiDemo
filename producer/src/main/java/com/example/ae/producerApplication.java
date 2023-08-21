package com.example.ae;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
//@EnableAspectJAutoProxy(proxyTargetClass = true)
public class producerApplication {

    public static void main(String[] args) {
        SpringApplication.run(producerApplication.class, args);
    }
}
