package app.admin.intra.command;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class IntraCommuteCommand {

	
	Integer comNo;
	String empId;
	Timestamp comDate;
	Timestamp comGo;
	Timestamp comLeave;
	String comIp;
}
