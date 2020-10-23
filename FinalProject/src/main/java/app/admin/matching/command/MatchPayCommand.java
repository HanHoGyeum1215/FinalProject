package app.admin.matching.command;

import lombok.Data;

@Data
public class MatchPayCommand {
	String memId;
	String matPayWay;
	String matPayPrice;
	String matPayReq;
}
