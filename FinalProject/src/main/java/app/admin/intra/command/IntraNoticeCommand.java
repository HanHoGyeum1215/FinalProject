package app.admin.intra.command;

import java.sql.Timestamp;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class IntraNoticeCommand {

	Integer notNo;
	String empId;
	String notSub;
	String notCont;
	Timestamp notDate;
	Integer notCount;
	String notOriginFile;
	String notStoreFile;
	Long notSize;
	MultipartFile report;
}
