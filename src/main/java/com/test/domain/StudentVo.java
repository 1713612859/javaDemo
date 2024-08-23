package com.test.domain;

import java.util.Date;

/**
 * @Desc StudentVo
 * @Author LiuYunLong
 */
public class StudentVo {

	 private int id;
	 private String studentName;
	 private int age;
	 private String stuGender;
	 private Date birthday;


	 public Date getBirthday() {
		  return birthday;
	 }

	 public void setBirthday(Date birthday) {
		  this.birthday = birthday;
	 }


	 public int getId() {
		  return id;
	 }

	 public void setId(int id) {
		  this.id = id;
	 }

	 public String getStudentName() {
		  return studentName;
	 }

	 public void setStudentName(String studentName) {
		  this.studentName = studentName;
	 }

	 public int getAge() {
		  return age;
	 }

	 public void setAge(int age) {
		  this.age = age;
	 }

	 public String getStuGender() {
		  return stuGender;
	 }

	 public void setStuGender(String stuGender) {
		  this.stuGender = stuGender;
	 }

	 @Override
	 public String toString() {
		  return "StudentVo{" + "id=" + id + ", studentName='" + studentName + '\'' + ", age=" + age + ", stuGender='" + stuGender + '\'' + ", birthday=" + birthday + '}';
	 }
}
