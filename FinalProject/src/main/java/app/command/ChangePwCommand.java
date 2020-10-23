package app.command;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class ChangePwCommand {
	@NotEmpty(message = "아이디를 입력하세요.")
	String userId;
	@NotEmpty(message = "이름을 입력하세요.")
	String userName;
	@NotEmpty(message = "이메일을 입력하세요.")
	String userEmail;
	@NotEmpty(message = "새 비밀번호를 입력하세요.")
	String newPw;
	@NotEmpty(message = "새 비밀번호 확인을 입력하세요.")
	String newPwCon;
	
	public boolean isNewPwToReNewPw() {
		if (newPw.equals(newPwCon)) {
			return true;
		}
		return false;
	}
	
}
