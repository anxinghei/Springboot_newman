package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.example.demo.mapper") // 指定该包下的所有接口为 Mapper
@SpringBootApplication
public class PeopelApplication {

	public static void main(String[] args) {
		SpringApplication.run(PeopelApplication.class, args);
	}

}
