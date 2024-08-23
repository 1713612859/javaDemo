package com.test.redistest;

import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Desc jedisTest
 * @Author LiuYunLong
 */
@Configuration
public class JedisTest {

	 private static final String REDIS_HOST = "localhost";
	 private static final int REDIS_PORT = 6379;


//	 public JedisPool jedisPoolConfig() {
//		  JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
//		  jedisPoolConfig.setMaxTotal(10000); // 设置最大连接数
//		  jedisPoolConfig.setMaxIdle(100000); // 设置最大空闲连接数
//		  jedisPoolConfig.setMinIdle(100); // 设置最小空闲连接数
//		  jedisPoolConfig.setBlockWhenExhausted(true); // 设置为true时，当资源耗尽时，调用者将等待
//		  jedisPoolConfig.setMaxWaitMillis(5000); // 设置最大等待时间
//		  return new JedisPool(jedisPoolConfig, REDIS_HOST, REDIS_PORT);
//	 }


	 public String generateOrderId(String prefix) {
		  if (prefix == null || prefix.length() != 3) {
				throw new IllegalArgumentException("Prefix must be 3 characters long.");
		  }

		  // 获取当前日期并格式化为yyyyMMdd
		  SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		  var date = new Date();
		  date.setDate(24);
		  String dateStr = dateFormat.format(date);

		  // Redis键名为 "OrderID:" + 日期
		  String key = "OrderID:" + dateStr;
		  // 创建Jedis客户端连接Redis
		  Jedis jedis = null;
		  try {
				jedis = new Jedis(REDIS_HOST, REDIS_PORT);
				// 检查键是否存在
				if (jedis != null && !jedis.exists(key)) {
					 // 如果键不存在，初始化为1，并设置过期时间为24小时
					 jedis.set(key, "0");
					 jedis.expire(key, 86400); // 86400秒 = 24小时
				}
				// 如果键已经存在，递增并获取流水号
				Long sequenceNumber = jedis.incr(key);

				// 格式化流水号为8位
				String sequenceStr = String.format("%08d", sequenceNumber);

				// 生成订单ID
				return prefix + dateStr + sequenceStr;
		  }
		  catch (Exception e) {
				// 处理可能发生的异常
				throw e;
		  }
		  finally {
				if (jedis != null) {
					 jedis.close();
				}
		  }

	 }

//	 public static void main(String[] args) throws InterruptedException {
////		  int totalCount = 10000; // 生成一百万个订单ID
////		  Set<String> orderIds = new HashSet<>(totalCount);
////		  String prefix = "ORD";
////		  boolean hasDuplicates = false;
////
////		  for (int i = 0; i < totalCount; i++) {
//////				if (i % 1000 == 0) {
//////					 Thread.sleep(1000); // 打印日志间隔1秒
//////				}
////				String orderId = generateOrderId(prefix);
//////				System.out.println("orderId = " + orderId);
////				if (!orderIds.add(orderId)) {
////					 System.out.println("Duplicate found: " + orderId);
////					 hasDuplicates = true;
////					 break;
////				}
////		  }
////
////		  if (!hasDuplicates) {
////				System.out.println("No duplicates found after generating " + totalCount + " order IDs.");
////		  }
//
//		  // 测试保存订单ID
//		  String orderId = generateOrderId("ORD");
//		  System.out.println("orderId = " + orderId);
//	 }
}
