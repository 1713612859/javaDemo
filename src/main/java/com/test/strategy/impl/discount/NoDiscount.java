package com.test.strategy.impl.discount;

import com.test.strategy.DiscountStrategy;

/**
 * @Desc NoDiscount
 * @Author LiuYunLong
 */
public class NoDiscount implements DiscountStrategy {
	 @Override
	 public double getDiscount() {
		  return 0;
	 }
}
