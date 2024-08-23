package com.test.swagger.config;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * @Desc JacksonConfig
 * @Author LiuYunLong
 */
@Configuration
public class JacksonConfig {


	 @Bean
	 @Primary
	 public ObjectMapper objectMapper() {
		  JavaTimeModule module = new JavaTimeModule();
		  LocalDateTimeDeserializer localDateTimeDeserializer = new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		  LocalDateDeserializer localDateDeserializer = new LocalDateDeserializer(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		  module.addDeserializer(LocalDateTime.class, localDateTimeDeserializer);
		  module.addDeserializer(LocalDate.class, localDateDeserializer);
		  module.addDeserializer(LocalDateTime.class, new CustomLocalDateTimeDeserializer());
		  return new ObjectMapper().registerModule(module);
	 }


	 /**
	  * 自定义 LocalDateTime 反序列化器
	  */
	 public static class CustomLocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {

		  @Override
		  public LocalDateTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
				JsonNode node = p.getCodec().readTree(p);
				String dateString = node.asText();

				try {
					 // 尝试将字符串解析为时间戳
					 long timestamp = Long.parseLong(dateString);
					 return LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), ZoneId.systemDefault());
				}
				catch (NumberFormatException e) {
					 // 如果解析失败，抛出异常
					 throw new IllegalArgumentException("Failed to deserialize LocalDateTime from String: " + dateString, e);
				}
		  }
	 }
}
