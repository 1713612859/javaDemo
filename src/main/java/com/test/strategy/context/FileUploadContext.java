package com.test.strategy.context;

import com.test.strategy.FileStrategy;
import org.springframework.stereotype.Component;

/**
 * @Desc FileUploadContext
 * @Author LiuYunLong
 */
@Component
public class FileUploadContext {

	 private FileStrategy fileStrategy;

	 public FileStrategy getFileStrategy() {
		  return fileStrategy;
	 }

	 public void setFileStrategy(FileStrategy fileStrategy) {
		  this.fileStrategy = fileStrategy;
	 }

	 public String executeUpload(String filePath) {
		  if (fileStrategy == null) {
				throw new IllegalStateException("No strategy set");
		  }
		  return fileStrategy.upload(filePath);
	 }
}
