package com.test;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.test.mapper"})
public class TestDemoApplication {

	 public static void main(String[] args) {
		  SpringApplication.run(TestDemoApplication.class, args);
	 }

}
