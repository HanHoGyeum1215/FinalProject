package app.admin.matching.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatchPayDTO {
	Long matPayNo;
	String memId;
	String matPayWay;
	String matPayPrice;
	String matPayReq;
}
