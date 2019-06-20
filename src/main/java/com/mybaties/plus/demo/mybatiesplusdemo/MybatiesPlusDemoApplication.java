package com.mybaties.plus.demo.mybatiesplusdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.mybaties.plus.demo.mybatiesplusdemo.mapper")
public class MybatiesPlusDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybatiesPlusDemoApplication.class, args);
	}

}
