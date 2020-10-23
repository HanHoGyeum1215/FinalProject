package app.admin.course.command;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class PartnerCommand {
	@Size(min = 4, max = 12,message = "아이디를 입력해주세요")
	String venId;
	@NotEmpty
	String venPass;
	@NotEmpty
	String reVenPass;
	@NotBlank(message = "이름을 입력해주세요")
	String venName;
	@NotNull
	@Size(min = 5, max = 13)
	String venTel;
	@NotNull
	String venNo;
	@NotNull
	String venAddr;
	@NotNull
	String venCeo;	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	LocalDateTime venCdate;
	@NotNull
	String venAcnt;	
	@NotNull
	String venAcntNo;	
	String venOk;
	
	public boolean isVenPassEqualToReVenPass() {
		if(venPass.equals(reVenPass)) {
			return true;
		} else {
			return false;
		}
	}
}
