package com.test.strategy.context;

import com.test.strategy.DiscountStrategy;
import com.test.strategy.impl.discount.BronzeMemberDiscount;
import com.test.strategy.impl.discount.GoldMemberDiscount;
import com.test.strategy.impl.discount.NoDiscount;
import com.test.strategy.impl.discount.SilverMemberDiscount;

/**
 * @Desc DiscountContext
 * @Author LiuYunLong
 */
public class DiscountContext {

	 private DiscountStrategy discountStrategy;

	 /**
	  * @param discountStrategy
	  */
	 public DiscountContext(DiscountStrategy discountStrategy) {
		  this.discountStrategy = discountStrategy;
	 }

	 /**
	  * @return double
	  */
	 public double executeStrategy() {
		  return discountStrategy.getDiscount();
	 }


	 public static void main(String[] args) {
		  DiscountContext noDiscount = new DiscountContext(new NoDiscount());
		  System.out.println(noDiscount.executeStrategy());

		  DiscountContext goldMemberDiscount = new DiscountContext(new GoldMemberDiscount());
		  System.out.println(goldMemberDiscount.executeStrategy());

		  DiscountContext bronzeMemberDiscount = new DiscountContext(new BronzeMemberDiscount());
		  System.out.println(bronzeMemberDiscount.executeStrategy());

		  DiscountContext sliverMemberDiscount = new DiscountContext(new SilverMemberDiscount());
		  System.out.println(sliverMemberDiscount.executeStrategy());

		  // 输出结果：
		  //		  0.0
		  //		  0.2
		  //		  0.1

	 }
}
