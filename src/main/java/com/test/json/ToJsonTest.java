package com.test.json;


import com.alibaba.fastjson2.JSON;

/**
 * @Desc ToJsonTest
 * @Author LiuYunLong
 */
public class ToJsonTest {

	 public static void main(String[] args) {
		  // TODO Auto-generated method stub
		  Person person = new Person();
		  person.setName("Tom");
		  person.setAge(25);

		  person.setGender("Male");
		  person.setAddress("China");
		  person.setHobbies(new String[]{"reading", "swimming"});
		  String jsonStr = JSON.toJSONString(person);

		  System.out.println(jsonStr);

		  // Output: {"name":"Tom","age":25,"gender":"Male","address":"China","hobbies":["reading","swimming"]}

		  var parseObject = JSON.parseObject(jsonStr, Person.class);
		  System.out.println(parseObject);
		  // Output: Person{name='Tom', age=25, gender='Male', address='China', hobbies=[reading, swimming]}

	 }


}
