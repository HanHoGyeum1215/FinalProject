package app.admin.matching.command;


import java.sql.Date;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class EventCommand {
	Long eveNo;
	@NotBlank(message = "장소를 입력하세요.")
	String eveLoc;
	Date eveDate;
	@Digits(integer = 3, fraction = 0)
	Long eveMxCnt;
	@NotBlank(message = "제목을 입력하세요.")
	String eveSubject;
	@NotBlank(message = "상세설명을 입력하세요.")
	String eveContent;
	MultipartFile [] eveImage;
	
}
