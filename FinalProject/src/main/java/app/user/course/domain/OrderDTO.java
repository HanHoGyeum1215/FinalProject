package app.user.course.domain;

import java.sql.Timestamp;

import app.admin.course.domain.StartEndPageDTO2;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
	public OrderDTO(String goods) {
		this.goodsNo = goods;
	}
	Long orderNo;
	String memId;
	String venId;
    String orderAddr;
	String orderMsg;
	String goodsNo;
	Timestamp orderDate;
//	String cartPrice;
	Long orderPrice;
	
	StartEndPageDTO2 startEndPageDTO;

	OrderDTO(Long orderNo, String memId, String venId, String orderAddr, String orderMsg, String goodsNo, Timestamp orderDate, Long orderPrice) {
		this.orderNo = orderNo;
		this.memId = memId;
		this.venId = venId;
		this.orderAddr = orderAddr;
		this.orderMsg = orderMsg;
		this.goodsNo = goodsNo;
		this.orderDate = orderDate;
		this.orderPrice = orderPrice;
	}
	
	


}
