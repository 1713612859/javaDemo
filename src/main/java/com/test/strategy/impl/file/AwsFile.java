package com.test.strategy.impl.file;

import com.test.strategy.FileStrategy;
import org.springframework.stereotype.Component;

/**
 * @Desc AwsFile
 * @Author LiuYunLong
 */

@Component("awsFile")
public class AwsFile implements FileStrategy {
	 @Override
	 public void strategy() {
		  System.out.println("This is AWS File");
	 }

	 @Override
	 public String upload(String fileName) {
		  System.out.println("Uploading to AWS with file name: "+ fileName);
		  return fileName;
	 }

	 @Override
	 public void download() {
		  System.out.println("Downloading from AWS");
	 }

	 @Override
	 public void delete() {
		  System.out.println("Deleting from AWS");
	 }
}
