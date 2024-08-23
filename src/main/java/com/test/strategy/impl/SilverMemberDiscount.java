package com.test.strategy.impl;

import com.test.strategy.DiscountStrategy;

/**
 * @Desc SilverMemberDiscount
 * @Author LiuYunLong
 */
public class SilverMemberDiscount implements DiscountStrategy {

	 /**
	  * @return
	  * @Desc 计算折扣
	  */
	 @Override
	 public double getDiscount() {
		  return 0.05;
	 }
}
