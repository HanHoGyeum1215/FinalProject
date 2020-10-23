package app.user.course.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartDTO {
	Long cartNo;
	String goodsNo;
	String memId;
	String venId;
	String goodsName;
	Long goodsPrice;
	String goodsImage;
	Long cartQty;
	Long cartPrice;
}
