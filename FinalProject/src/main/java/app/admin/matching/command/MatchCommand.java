package app.admin.matching.command;

import java.sql.Date;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatchCommand {
	Integer matNo;
	@NotBlank(message = "아이디를 입력하세요.")
	String memId;
	@NotBlank(message = "아이디를 입력하세요.")
	String partnerId;
	Date matDate;
	String matCheck;
	String matLoc;
}
