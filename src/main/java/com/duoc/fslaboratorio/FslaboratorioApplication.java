package com.duoc.fslaboratorio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.duoc")               
@EnableJpaRepositories(basePackages = "com.duoc")       
@EntityScan(basePackages = "com.duoc")                  
public class FslaboratorioApplication {
    public static void main(String[] args) {
        SpringApplication.run(FslaboratorioApplication.class, args);
    }
}
