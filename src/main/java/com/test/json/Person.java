package com.test.json;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @Desc Person
 * @Author LiuYunLong
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class Person {
	 private String name;
	 private int age;
	 private String gender;
	 private String address;
	 private String phone;
	 private String email;

	 private String[] hobbies;

}
