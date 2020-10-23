package app.admin.matching.domain;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberAddDTO {
	String memId;
	String memCareer;
	String memJob;
	String memSalary;
	String memHgt;
	String memWgt;
	String memBlood;
	String memHobby;
	String memRlg;
	String memOriginalImage;
	String memStoreImage;
	Timestamp memExp;
	Long memMat;
}
