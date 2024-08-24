package com.test.future;

/**
 * @Desc FutureTest
 * @Author LiuYunLong
 */

public class FutureTest {

//@Test1
//	 public static void main(String[] args) throws ExecutionException, InterruptedException {
//		  CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "hello world").thenApply(s -> {
//				System.out.println("thenApply: " + s);
//				return s.toUpperCase();
//		  });
//
//		  System.out.println("future: " + future.getNow(null));
//
//	 }


	 //	 Test2
//	 public static void main(String[] args) {
//		  CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
//				// Some long-running operation
//				return "Result 1";
//		  });
//
//		  CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
//				// Some long-running operation
//				return "Result 2";
//		  });
//
//		  CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> {
//				// Some long-running operation
//				return "Result 3";
//		  });
//
//		  CompletableFuture<Void> allFutures = CompletableFuture.allOf(future1, future2, future3);
//
//		  allFutures.thenRun(() -> {
//				// All futures completed
//				String result1 = future1.join();
//				String result2 = future2.join();
//				String result3 = future3.join();
//				System.out.println(result1 + ", " + result2 + ", " + result3);
//		  });
//	 }

//@TEST4 多任务执行 异常 处理
//	 public static void main(String[] args) {
//		  CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
//				// Some long-running operation
//				return 10;
//		  });
//
//		  CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
//				int result = 10 / 1; // Causes an ArithmeticException
//				return result;
//		  });
//
//		  CompletableFuture<Integer> future3 = CompletableFuture.supplyAsync(() -> {
//				// Some long-running operation
//				return 20;
//		  });
//
//		  CompletableFuture<Void> allFutures = CompletableFuture.allOf(future1, future2, future3);
//
//		  allFutures.exceptionally(ex -> {
//				System.out.println("Exception occurred: " + ex.getMessage());
//				return null; // Default value to return if there's an exception
//		  }).thenRun(() -> {
//				// All futures completed
//				int result1 = future1.join();
//				int result2 = future2.join();
//				int result3 = future3.join();
//				System.out.println(result1 + ", \n" + result2 + ", \n" + result3);
//
//		  });
//	 }

	 // Test5
//	 public static void main(String[] args) {
//		  // 创建第一个 CompletableFuture，返回 "Hello"
//		  CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "Hello");
//
//		  // 使用 thenComposeAsync 将 future1 的结果与另一个 CompletableFuture 组合，返回 "Hello World"
//		  CompletableFuture<String> future2 = future1.thenComposeAsync(s -> CompletableFuture.supplyAsync(() -> s + " World"));
//
//		  // 使用 thenAccept 处理 future2 的结果，并打印出来
//		  future2.thenAccept(result -> System.out.println(result)).join(); // 确保所有异步任务都完成后再结束程序
//	 }


	 // Test6
	 // RestTemplate 异步调用
	 public static void main(String[] args) {
		  //		  @Service
		  //		  public class AggregatorService {
		  //				@Autowired
		  //				private AsyncRestTemplate restTemplate;
		  //
		  //				public AggregatedResponse getAggregatedResponse() {
		  //				public CompletableFuture<AggregatedResponse> getAggregatedResponse() {
		  // 创建三个 CompletableFuture，分别从三个不同的服务获取用户、产品和订单数据
		  //
		  //					 CompletableFuture<User[]> usersFuture = CompletableFuture.supplyAsync(() -> {
		  //						  return restTemplate.getForObject("http://localhost:8080/users", User[].class);
		  //					 });
		  //
		  //					 CompletableFuture<Product[]> productsFuture = CompletableFuture.supplyAsync(() -> {
		  //						  return restTemplate.getForObject("http://localhost:8080/products", Product[].class);
		  //					 });
		  //
		  //					 CompletableFuture<Order[]> ordersFuture = CompletableFuture.supplyAsync(() -> {
		  //						  return restTemplate.getForObject("http://localhost:8080/orders", Order[].class);
		  //					 });
		  //
		  //					 return CompletableFuture.allOf(usersFuture, productsFuture, ordersFuture)
		  //								.thenApply(v -> new AggregatedResponse(usersFuture.join(), productsFuture.join(), ordersFuture.join()));
		  //				}

		  // return responseFuture;

	 }

}
