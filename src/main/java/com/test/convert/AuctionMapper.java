package com.test.convert;

import com.test.domain.Auction;
import com.test.domain.AuctionTableVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * mapstruct convert instance
 *
 * @Desc UserMapper
 * @Author LiuYunLong
 */
@Mapper
public interface AuctionMapper {

	 AuctionMapper INSTANCE = Mappers.getMapper(AuctionMapper.class);

	 /**
	  * 将AuctionTableVO对象转换为Auction对象。
	  * 这个方法用于将视图对象转换为领域模型对象，以便进行进一步的处理或持久化。
	  *
	  * @param auction 源AuctionTableVO对象，包含拍卖的详细信息和版本信息。
	  * @return 返回一个新的Auction对象，包含了从AuctionTableVO转换过来的数据。
	  */
	 Auction auctionVOToAuction(AuctionTableVO auction);

	 /**
	  * 将Auction对象转换为AuctionTableVO对象。
	  * 这个方法用于将领域模型对象转换为视图对象，以便展示给用户或进行传输。
	  *
	  * @param auction 源Auction对象，包含拍卖的基础信息。
	  * @return 返回一个新的AuctionTableVO对象，包含了从Auction转换过来的数据，以及额外的详细信息和版本信息。
	  */
	 AuctionTableVO auctionToAuctionVO(Auction auction);


	 public class test {

		  public static void main(String[] args) {
				var tableVO = new AuctionTableVO();

				tableVO.setId(100000L);
				tableVO.setTitle("title_ 100000L");
				tableVO.setDescription("description_ 100000L");

				var auction = AuctionMapper.INSTANCE.auctionVOToAuction(tableVO);

				var toAuctionVO = AuctionMapper.INSTANCE.auctionToAuctionVO(auction);

				System.out.println("toAuctionVO = " + toAuctionVO);

				System.out.println("auction = " + auction);

		  }
	 }

}
