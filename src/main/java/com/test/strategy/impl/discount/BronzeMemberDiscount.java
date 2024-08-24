package com.test.strategy.impl.discount;

import com.test.strategy.DiscountStrategy;

/**
 * @Desc BronzeMemberDiscount
 * @Author LiuYunLong
 */
public class BronzeMemberDiscount implements DiscountStrategy {


	 /**
	  * @return
	  * @Desc 计算折扣
	  * @Author LiuYunLong
	  */
	 @Override
	 public double getDiscount() {
		  return 0.1;
	 }
}
