package com.test.strategy.impl;

import com.test.strategy.FileStrategy;
import org.springframework.stereotype.Component;

/**
 * @Desc AliyunFile
 * @Author LiuYunLong
 */
@Component("aliyunFile")
public class AliyunFile implements FileStrategy {
	 @Override
	 public void strategy() {
		  System.out.println("AliyunFile upload");
	 }

	 @Override
	 public String upload(String fileName) {
		  System.out.println("AliyunFile upload fileName : " + fileName);
		  return "AliyunFile upload fileName :"+ fileName;
	 }

	 @Override
	 public void download() {
		  System.out.println("AliyunFile download");
	 }

	 @Override
	 public void delete() {
		  System.out.println("AliyunFile delete");
	 }
}
