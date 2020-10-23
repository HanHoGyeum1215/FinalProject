package app.command;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class ChangeIdCommand {
	@NotEmpty(message = "이름을 입력하세요.")
	String userName;
	@NotEmpty(message = "이메일을 입력하세요.")
	String userEmail;
	@NotEmpty(message = "전화번호를 입력하세요.")
	String userTel;
}