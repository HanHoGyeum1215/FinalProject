package app.admin.matching.command;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class MemberLoginCommand {
	@NotBlank
	String userId;
	String userPw;
	String path;
}
