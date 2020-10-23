package app.admin.intra.domain;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class IntraCommuteDTO {

	Integer comNo;
	String empId;
	Timestamp comDate;
	Timestamp comGo;
	Timestamp comLeave;
	String comIp;
}
