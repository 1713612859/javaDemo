package com.test.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Desc AuctionVersion
 * @Author LiuYunLong
 */
@Data
@TableName(value = "auction_version")
public class AuctionVersion {
	 /**
	  * 拍卖版本号的唯一标识符
	  */
	 @TableId(value = "id", type = IdType.AUTO)

	 private Long id;
	 /**
	  * 关联 Auction 的 id
	  */
	 @TableField(value = "auction_id")
	 private Long auctionId;
	 /**
	  * 版本号自增+1
	  */
	 @TableField(value = "version")
	 private Integer version;
	 /**
	  * 创建人
	  */
	 @TableField(value = "created_by")
	 private String createdBy;
	 /**
	  * 创建时间
	  */
	 @TableField(value = "created_at")
	 private String createdAt;

	 /**
	  * 扩展JSON
	  */
	 @TableField(value = "extra_json")
	 private String extraJson;
}
