package com.hh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hh.mapper")
public class OooopApplication {

    public static void main(String[] args) {
        SpringApplication.run(OooopApplication.class, args);
    }

}
