package com.test.controller;

import com.test.strategy.FileStrategy;
import com.test.strategy.context.FileUploadContext;
import com.test.strategy.impl.AliyunFile;
import com.test.strategy.impl.AwsFile;
import com.test.strategy.impl.DefaultFile;
import com.test.strategy.impl.MiniIOFile;
import jakarta.annotation.Resource;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Optional;

/**
 * @Desc FileController
 * @Author LiuYunLong
 */
@RestController
@RequestMapping("/file/")
@Validated
public class FileController {

	 @Value("${upload.path}")
	 private String UPLOAD_PATH;

	 @Resource
	 private AwsFile awsFile;

	 @Resource
	 private AliyunFile aliyunFile;

	 @Resource
	 private DefaultFile defaultFile;

	 @Resource
	 private MiniIOFile miniIOFile;

	 @Value("${upload.strategy}")
	 private String strategy;

	 @Resource
	 private FileUploadContext fileUploadContext;


	 @RequestMapping("/upload")
	 public String upload(@NotNull String fileName) {
		  return doUpload(fileName);
	 }

	 public String doUpload(String fileName) {
		  // 选择上传策略
		  // 这里可以根据实际情况选择不同的策略
		  // 获取redis中的策略
//		  Jedis jedis = new Jedis("localhost");
//		  strategy = jedis.get("strategy");
		  // 或者根据参数选择策略
		  // Define a map of strategies
		  Map<String, FileStrategy> strategies = Map
					 .of("awsFile", awsFile,
								"aliyunFile", aliyunFile,
								"miniIOFile", miniIOFile);

		  // Get the strategy from Redis or any other source
		  // Jedis jedis = new Jedis("localhost");
		  // String strategy = jedis.get("strategy");

		  // Select the strategy based on the retrieved value
		  FileStrategy fileStrategy = Optional.ofNullable(strategy).map(strategies::get).orElse(defaultFile);

		  // Set the strategy and execute the upload
		  fileUploadContext.setFileStrategy(fileStrategy);
		  return fileUploadContext.executeUpload(fileName + UPLOAD_PATH);
	 }

}
