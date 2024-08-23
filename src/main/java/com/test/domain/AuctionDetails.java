package com.test.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * AuctionDetails 表示拍卖中具体物品的详细信息。
 * 该类包含了物品的描述、起拍价、当前出价和拍卖结束时间等信息。
 */
@Data
@TableName(value = "auction_details")
public class AuctionDetails {

	 /**
	  * 拍卖详情的唯一标识符。
	  */
	 @TableId(value = "id", type = IdType.AUTO)
	 private Long id;

	 /**
	  * 关联的拍卖的唯一标识符，对应 Auction 类的 id。
	  */
	 @TableField("auction_id")
	 private Long auctionId;

	 /**
	  * 拍卖物品的描述，提供物品的详细信息。
	  */
	 @TableField("item_description")
	 private String itemDescription;

	 /**
	  * 该拍卖物品的起拍价。
	  */
	 @TableField("starting_bid")
	 private Double startingBid;

	 /**
	  * 当前的最高出价。
	  */
	 @TableField("current_bid")
	 private Double currentBid;

	 /**
	  * 拍卖的结束时间，格式为字符串。
	  */
	 @TableField("bid_end_time")
	 private String bidEndTime;
}