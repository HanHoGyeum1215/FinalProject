package app.admin.course.command;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class CourseCommand {
	
	String venId;
	@NotNull
	String goodsType;
	@NotNull
	String goodsNo;
	@NotBlank(message = "이름을 입력해주세요")
	String goodsName;
	@NotNull
	Long goodsPrice;
	@NotNull
	String goodsDet;
	@NotNull
	MultipartFile [] goodsImage;

}
