package com.orthopaedicsystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.orthopaedicsystem.mapper")
public class OrthopaedicSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrthopaedicSystemApplication.class, args);
    }

}
