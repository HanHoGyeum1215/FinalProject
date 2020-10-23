package app.admin.matching.domain;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO implements Serializable {
	String memId;
	String memName;
	Date memBirth;
	String memAddr;
	String memTel;
	String memEmail;
	String memPass;
	String memGender;
	Timestamp memRegist;
	
	MemberAddDTO memberAdd;
}
