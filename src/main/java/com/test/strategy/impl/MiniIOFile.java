package com.test.strategy.impl;

import com.test.strategy.FileStrategy;
import org.springframework.stereotype.Component;

/**
 * @Desc MiniIOFile
 * @Author LiuYunLong
 */

@Component("miniIOFile")
public class MiniIOFile implements FileStrategy {
	 @Override
	 public void strategy() {
		  System.out.println("MiniIOFile strategy");
	 }

	 @Override
	 public String upload(String fileName) {
		  System.out.println("MiniIOFile upload fileName" + fileName);
		  return fileName;
	 }

	 @Override
	 public void download() {
		  System.out.println("MiniIOFile download");
	 }

	 @Override
	 public void delete() {
		  System.out.println("MiniIOFile delete");
	 }
}
