package com.test.strategy;

/**
 * @Desc FileStrategy
 * @Author LiuYunLong
 */
// Define the interface of file strategy
public interface FileStrategy {

	 // Define the strategy method
	 public void strategy();

	 // Define the upload and download method
	 public String upload(String fileName);

	 // Define the download method
	 public void download();


	 // Define the delete method
	 public void delete();

}
