package app.admin.matching.domain;


import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatchDTO {
	Integer matNo;
	String memId;
	String partnerId;
	String empId;
	Date matDate;
	String matCheck;
	String matLoc;
	String memName;
	String partnerName;
	Date memBirth;
	String memGender;
	
}
