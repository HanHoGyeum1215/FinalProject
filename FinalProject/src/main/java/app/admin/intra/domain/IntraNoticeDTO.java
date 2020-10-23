package app.admin.intra.domain;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class IntraNoticeDTO {

	Integer notNo;
	String empId;
	String notSub;
	String notCont;
	Timestamp notDate;
	Integer notCount;
	String notOriginFile;
	String notStoreFile;
	Long notSize;
}
