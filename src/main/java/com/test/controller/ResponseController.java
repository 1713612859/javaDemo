package com.test.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @Desc ResponseController
 * @Author LiuYunLong
 */
@RestController
@RequestMapping("/response/")
public class ResponseController {

	 @RequestMapping("/responseText")
	 public void responseText(HttpServletResponse response) {
		  response.setContentType("text/plain");
		  response.setHeader("Cache-Control", "no-cache");
		  response.setCharacterEncoding("UTF-8");
		  try {
				response.getWriter().write("Hello World!");
		  }
		  catch (Exception e) {
				e.printStackTrace();
		  }
	 }


	 @RequestMapping("/responseJPG")
	 public void responseJPG(HttpServletRequest request, HttpServletResponse response) {
		  response.setContentType("image/jpeg");
		  response.setHeader("Cache-Control", "no-cache");
		  response.setCharacterEncoding("UTF-8");

		  try {
				URL url = new URL("https://images.pexels.com/photos/1000498/pexels-photo-1000498.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");
				HttpURLConnection connection = (HttpURLConnection) url.openConnection();
				connection.setRequestProperty("User-Agent", "Mozilla/5.0"); // 添加用户代理头

				try (InputStream inputStream = connection.getInputStream(); OutputStream outputStream = response.getOutputStream()) {
					 byte[] buffer = new byte[4096];
					 int bytesRead;
					 while ((bytesRead = inputStream.read(buffer)) != -1) {
						  outputStream.write(buffer, 0, bytesRead);
					 }
				}
		  }
		  catch (Exception e) {
				e.printStackTrace();
		  }
	 }
}


