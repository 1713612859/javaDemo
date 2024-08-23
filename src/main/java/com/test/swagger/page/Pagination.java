package com.test.swagger.page;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

/**
 * @Desc Pagination
 * @Author LiuYunLong
 */

public class Pagination {

	 @Min(value = 1, message = "页码必须大于等于1")
	 @NotNull(message = "页码不能为空")
	 private Integer page;

	 @Min(value = 1, message = "每页显示的记录数必须大于等于1")
	 @NotNull(message = "每页显示的记录数不能为空")
	 private int size;

	 // 默认构造函数
	 public Pagination() {
		  this.page = 1; // 默认第一页
		  this.size = 10; // 默认每页10条记录
	 }

	 // 带参数的构造函数
	 public Pagination(int page, int size) {
		  this.page = page;
		  this.size = size;
	 }

	 // Getters and Setters
	 public int getPage() {
		  return page;
	 }

	 public void setPage(int page) {
		  this.page = page;
	 }

	 public int getSize() {
		  return size;
	 }

	 public void setSize(int size) {
		  this.size = size;
	 }

	 @Override
	 public String toString() {
		  return "Pagination{" + "page=" + page + ", size=" + size + '}';
	 }
}
