package com.test;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.util.DateUtils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.test.domain.Auction;
import com.test.domain.AuctionDetails;
import com.test.domain.AuctionTableVO;
import com.test.domain.AuctionVersion;
import com.test.mapper.AuctionDetailsMapper;
import com.test.mapper.AuctionMapper;
import com.test.mapper.AuctionVersionMapper;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class TestDemoApplicationTests {

	 @Resource
	 private AuctionMapper auctionMapper;
	 @Resource
	 private AuctionDetailsMapper auctionDetailsMapper;
	 @Resource
	 private AuctionVersionMapper auctionVersionMapper;


	 @Test
	 public void Test1() {
		  var queryWrapper = new LambdaQueryWrapper<Auction>();
		  queryWrapper.eq(Auction::getId, 1);
		  var auction = auctionMapper.selectOne(queryWrapper);
		  if (auction == null) {
				return;
		  }
		  Long id = auction.getId();
		  LambdaQueryWrapper<AuctionDetails> detailQuery = new LambdaQueryWrapper<AuctionDetails>();
		  detailQuery.eq(AuctionDetails::getAuctionId, id);
		  List<AuctionDetails> auctionDetails = auctionDetailsMapper.selectList(detailQuery);

		  LambdaQueryWrapper<AuctionVersion> versionQuery = new LambdaQueryWrapper<AuctionVersion>();
		  versionQuery.eq(AuctionVersion::getAuctionId, id);
//		  List<AuctionVersion> auctionVersions = auctionVersionMapper.selectList(versionQuery);
		  var auctionVersions = auctionVersionMapper.selectList(versionQuery);

		  AuctionTableVO tableVO = new AuctionTableVO();
		  BeanUtils.copyProperties(auction, tableVO);
		  tableVO.setAuctionDetails(auctionDetails);
		  tableVO.setAuctionVersions(auctionVersions);
	 }

	 @Test
	 public void TestInsert() {

		  var s = new String();

		  Auction auction = new Auction();
		  auction.setStatus(1);
		  auction.setTitle("测试TITLE");
		  auction.setVersion(1);
		  auction.setDescription("测试DESCRIPTION");
		  auctionMapper.insert(auction);

		  AuctionDetails auctionDetails = new AuctionDetails();
		  auctionDetails.setAuctionId(auction.getId());
		  auctionDetails.setBidEndTime(DateUtils.format(new Date()));
		  auctionDetails.setStartingBid(100D);
		  auctionDetails.setCurrentBid(1000D);
		  auctionDetails.setItemDescription("DETAIL DESCRIPTION");
		  auctionDetailsMapper.insert(auctionDetails);

		  AuctionDetails auctionDetails2 = new AuctionDetails();
		  auctionDetails2.setAuctionId(auction.getId());
		  auctionDetails2.setBidEndTime(DateUtils.format(new Date()));
		  auctionDetails2.setStartingBid(500D);
		  auctionDetails2.setCurrentBid(5000d);
		  auctionDetails2.setItemDescription("DETAIL2 DESCRIPTION");
		  auctionDetailsMapper.insert(auctionDetails2);

		  AuctionVersion auctionVersion = new AuctionVersion();
		  auctionVersion.setAuctionId(auction.getId());
		  auctionVersion.setVersion(auction.getVersion());
		  auctionVersion.setCreatedAt(DateUtils.format(new Date()));
		  auctionVersion.setCreatedBy("liuyunlong");
		  // setExtraJson
		  AuctionTableVO tableVO = new AuctionTableVO();
		  BeanUtils.copyProperties(auction, tableVO);
		  tableVO.setAuctionDetails(Arrays.asList(auctionDetails, auctionDetails2));
		  tableVO.setAuctionVersions(Arrays.asList(auctionVersion));
		  auctionVersion.setExtraJson(JSON.toJSONString(tableVO));

		  auctionVersionMapper.insert(auctionVersion);

	 }

	 @Test
	 public void TEST_BACK_EXTRA_JSON() {
		  LambdaQueryWrapper<AuctionVersion> queryWrapper = new LambdaQueryWrapper<>();
		  queryWrapper.eq(AuctionVersion::getAuctionId, 1L);
		  List<AuctionVersion> auctionVersions = auctionVersionMapper.selectList(queryWrapper);
		  if (CollectionUtils.isEmpty(auctionVersions)) {
				return;
		  }
		  Optional<AuctionVersion> first = auctionVersions.stream().findFirst();
//		  first.
		  if (first.isPresent() && first.get().getExtraJson() != null) {
				AuctionTableVO tableVO = JSON.parseObject(first.get().getExtraJson(), AuctionTableVO.class);
				List<AuctionDetails> auctionDetails = tableVO.getAuctionDetails();
				auctionDetails.forEach(auctionDetailsMapper::updateById);
				auctionMapper.updateById(tableVO);
		  }
	 }

}
