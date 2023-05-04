package com.example.hxcom;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.hxcom.mapper")
public class HxComApplication {

    public static void main(String[] args) {
        SpringApplication.run(HxComApplication.class, args);
    }

}
