package com.test;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Set;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @Desc IdUtils
 * @Author LiuYunLong
 */
public class IdUtils {
	 private static final AtomicLong counter = new AtomicLong(0);
	 private static final long MACHINE_ID = getMachineId();
	 private static final long EPOCH = 1622505600000L; // 可以设置为一个固定的时间戳，例如2021-06-01 00:00:00

	 public static long generateUUIDShort() {
		  long timestamp = (System.currentTimeMillis() - EPOCH) << 22; // 左移22位留给机器ID和计数器
		  long id = (MACHINE_ID << 12) | (counter.getAndIncrement() & 0xFFF); // 机器ID占用10位，计数器占用12位
		  return timestamp | id;
	 }

	 private static long getMachineId() {
		  try {
				InetAddress ip = InetAddress.getLocalHost();
				byte[] ipAddress = ip.getAddress();
				return ((ipAddress[ipAddress.length - 2] & 0B11) << 8) | (ipAddress[ipAddress.length - 1] & 0xFF);
		  }
		  catch (UnknownHostException e) {
				e.printStackTrace();
				return 1L; // 默认返回1作为机器ID
		  }
	 }

	 public static void main(String[] args) throws ExecutionException, InterruptedException {

		  Set<Long> set = new ConcurrentSkipListSet<Long>();
		  var start = System.currentTimeMillis();
		  var executorService = Executors.newFixedThreadPool(15);
		  for (int i = 0; i < 1000_000; i++) {
				Future<?> submit = executorService.submit(() -> {
					 var uuidShort = generateUUIDShort();
					 set.add(uuidShort);
				});
				Object o = submit.get();

		  }
		  // 关闭线程池，不再接受新任务
		  executorService.shutdown();

		  try {
				// 等待所有任务完成，最多等待1分钟
				if (!executorService.awaitTermination(1, TimeUnit.MINUTES)) {
					 System.out.println("Not all tasks completed within the timeout.");
					 executorService.shutdownNow(); // 超时后强制关闭
				}
		  }
		  catch (InterruptedException e) {
				e.printStackTrace();
				executorService.shutdownNow();
		  }

		  var end = System.currentTimeMillis();
		  // 获取最终的 set 大小
		  System.out.println(end - start / 1000);
		  System.out.println("Set size: " + set.size());

	 }
}
