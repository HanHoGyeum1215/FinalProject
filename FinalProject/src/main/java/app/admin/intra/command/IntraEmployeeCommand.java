package app.admin.intra.command;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class IntraEmployeeCommand {
	@Size(min = 6, max = 12, message = "아이디를 입력하세요.")
	String empId;
	Long depNo;
	@NotEmpty(message = "비밀번호를 입력하세요.")
	// @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,20}", message = "비밀번호는 영문 대, 소문자 숫자, 특수기호가 적어도 1개 이상씩 포함된 8자~ 20자의 비밀번호이어야 합니다.")
	String empPass;
	@NotEmpty(message = "이름을 입력하세요.")
	String empName;
	@NotEmpty(message = "이메일을 입력하세요.")
	@Email
	String empEmail;
	@Size(min = 12, max = 13, message = "전화번호를 입력하세요.")
	String empTel;
	String empDuty;
	
}
