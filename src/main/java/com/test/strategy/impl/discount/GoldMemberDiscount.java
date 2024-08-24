package com.test.strategy.impl.discount;

import com.test.strategy.DiscountStrategy;

/**
 * @Desc GoldMemberDiscount
 * @Author LiuYunLong
 */
public class GoldMemberDiscount implements DiscountStrategy {

	 /**
	  * @param
	  * @return
	  * @Desc 计算折扣
	  * @Author LiuYunLong
	  */
	 @Override
	 public double getDiscount() {
		  return 0.2;
	 }
}
