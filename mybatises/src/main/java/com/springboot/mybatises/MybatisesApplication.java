package com.springboot.mybatises;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.springboot.mybatises.Dao.test1","com.springboot.mybatises.Dao.test2"})
public class MybatisesApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisesApplication.class, args);
    }

}
