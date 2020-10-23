package app.admin.intra.command;

import java.sql.Timestamp;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class IntraAskCommand {

	Integer askNo;
	String empId;
	String askSub;
	String askCont;
	Timestamp askDate;
	Integer askCount;
	String askOriginFile;
	String aksStoreFile;
	Long askSize;
	MultipartFile report;
}
