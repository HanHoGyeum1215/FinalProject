package app.admin.matching.command;


import java.sql.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class MemberCommand {
	@NotBlank(message = "아이디를 입력하세요.")
	String memId;
	
	@NotBlank(message = "이름을 입력하세요.")
	String memName;
	
	@NotNull(message = "생년월일을 입력하세요.")
	Date memBirth;
	
	@NotBlank(message = "주소를 입력하세요.")
	String memAddr;
	
	@NotBlank(message = "전화번호를 입력하세요.")
	String memTel;
	
	@NotBlank(message = "이메일을 입력하세요.")
	@Email
	String memEmail;
	
	@NotBlank(message = "패스워드를 입력하세요.")
	String memPass;
	
	String memPassCon;
	String memGender;
	public boolean isUserPwEqualToUserPwCon() {
		if(memPass.equals(memPassCon)) {
			return true;
		}
		return false;
	}
	
}
