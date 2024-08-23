package com.test.domain;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @Desc AuctionTableVO
 * @Author LiuYunLong
 */
@Data
@ToString(callSuper = true)
public class AuctionTableVO extends Auction {

	 private List<AuctionDetails> auctionDetails;

	 private List<AuctionVersion> auctionVersions;
}
