package app.admin.course.command;

import java.time.LocalDateTime;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class MemberCommand2 {
	@Size(min = 4, max = 12,message = "아이디를 입력해주세요")
	String memId;
	@NotEmpty
	String memPass;
	@NotEmpty
	String reMemPass;
	@NotBlank(message = "이름을 입력해주세요")
	String memName;
	@NotNull
	String memAddr;
	@NotNull
	@Email
	String memEmail;
	@NotNull
	@Size(min = 5, max = 13)
	String memTel;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	LocalDateTime memBirth;
	
	public boolean isMemPassEqualToReMemPass() {
		if(memPass.equals(reMemPass)) {
			return true;
		} else {
			return false;
		}
	}
}
