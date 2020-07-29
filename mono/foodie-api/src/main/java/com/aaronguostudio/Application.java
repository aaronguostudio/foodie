package com.aaronguostudio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.aaronguostudio.mapper") // scan MyBatis
@ComponentScan(basePackages = {"com.aaronguostudio", "org.n3r.idworker"}) // scan all packages for injection
public class Application {
    public static void main (String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
