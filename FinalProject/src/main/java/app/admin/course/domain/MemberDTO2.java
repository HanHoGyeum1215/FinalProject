package app.admin.course.domain;


import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias(value = "memberDTO")
public class MemberDTO2 {
	String memId;
	String memPass;
	String memName;
	Timestamp memBirth;
	String memAddr;
	String memTel;
	String memEmail;
	
	StartEndPageDTO2 startEndPageDTO;
	
	public MemberDTO2(String memId, String memPass, String memName, Timestamp memBirth, String memAddr,
		   String memTel, String memEmail) {
		this.memId = memId;
		this.memPass = memPass;
		this.memName = memName;
		this.memBirth = memBirth;
		this.memAddr = memAddr;
		this.memTel = memTel;
		this.memEmail = memEmail;
	}	



}
