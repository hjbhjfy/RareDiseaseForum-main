package com.backend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.backend.modules.dao")
public class DiseaseForumApplication {
    public static void main(String[] args) {
        SpringApplication.run(DiseaseForumApplication.class, args);
    }
}
