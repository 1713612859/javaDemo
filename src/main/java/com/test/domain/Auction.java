package com.test.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

/**
 * Auction 表示一次拍卖活动，包含了拍卖的标题、描述、版本号和状态等信息。
 * 该类用于管理拍卖的整个生命周期，从创建到最终交易结果。
 */
@Data
@TableName(value = "auction")
@ToString
public class Auction {

	 /**
	  * 拍卖的唯一标识符。
	  */
	 @TableId(value = "id", type = IdType.AUTO)
	 private Long id;

	 /**
	  * 拍卖的标题，通常是对拍卖物品的简短描述。
	  */
	 @TableField("title")
	 private String title;

	 /**
	  * 拍卖活动的详细描述，提供关于拍卖物品或服务的更多上下文信息。
	  */
	 @TableField("description")
	 private String description;

	 /**
	  * 拍卖的版本号，用于跟踪拍卖信息的变更或更新。
	  */
	 @TableField("version")
	 private Integer version;

	 /**
	  * 拍卖的状态，指示其在拍卖生命周期中的当前阶段。
	  * 可能的值包括：
	  * 0 - 未提交：拍卖已创建但尚未提交。 <br></>
	  * 1 - 已提交：拍卖已提交，等待审核。
	  * 2 - 审批通过：拍卖已通过审核，准备开始。
	  * 3 - 拍卖中：拍卖正在进行中。
	  * 4 - 交易成功：拍卖已成功结束，并完成交易。
	  * 5 - 交易失败：拍卖结束但未能成功交易。
	  */
	 @TableField("status")
	 private Integer status;

}

