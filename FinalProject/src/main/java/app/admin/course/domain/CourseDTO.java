package app.admin.course.domain;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDTO {
	String venId;
	String goodsType;
	String goodsNo;
	String goodsName;
	Long goodsPrice;
	String goodsDet;
	String goodsImage;
	
	StartEndPageDTO2 startEndPageDTO;
	
	public CourseDTO(String venId, String goodsType, String goodsNo,  String goodsName, Long goodsPrice, String goodsDet, String goodsImage) {
		this.venId = venId;
		this.goodsType = goodsType;
		this.goodsNo = goodsNo;
		this.goodsName = goodsName;
		this.goodsPrice = goodsPrice;
		this.goodsDet = goodsDet;
		this.goodsImage = goodsImage;
	}

    
}
