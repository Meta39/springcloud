package com.jw.ums;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.jw.ums.dao")
public class UmsApplication {
    public static void main(String[] args) {
        SpringApplication.run(UmsApplication.class,args);
    }
}
