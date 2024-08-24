package com.test.strategy.impl.file;

import com.test.strategy.FileStrategy;
import org.springframework.stereotype.Component;

/**
 * @Desc DefaultFile
 * @Author LiuYunLong
 */

@Component("defaultFile")
public class DefaultFile implements FileStrategy {
	 @Override
	 public void strategy() {
		  System.out.println("默认文件策略");
	 }

	 @Override
	 public String upload(String fileName) {
		  System.out.println("默认文件上传 fileName: " + fileName);
		  return fileName;
	 }

	 @Override
	 public void download() {
		  System.out.println("默认文件下载");
	 }

	 @Override
	 public void delete() {
		  System.out.println("默认文件删除");
	 }
}
