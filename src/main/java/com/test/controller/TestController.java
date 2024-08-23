package com.test.controller;

import com.alibaba.fastjson2.JSON;
import com.test.redistest.JedisTest;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;

/**
 * @Desc TestController
 * @Author LiuYunLong
 */
@RestController
@RequestMapping("/test")
public class TestController {

	 @Value("${order-id}")
	 String ORDERID;

	 @Resource
	 private JedisTest jedisTest;

	 @RequestMapping("/hello")
	 public String test(String prefix) {
		  HashSet<String> set = new HashSet<>();
		  if (prefix == null) {
				return "";
		  }
		  for (int i = 0; i < 10; i++) {
				String id = jedisTest.generateOrderId(ORDERID);
				set.add(id);
		  }
		  return String.valueOf(set.size());
	 }
}
