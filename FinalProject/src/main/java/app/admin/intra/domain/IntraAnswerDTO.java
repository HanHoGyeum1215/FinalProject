package app.admin.intra.domain;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IntraAnswerDTO {
	String sempId;
	String ansCont;
	Integer askNo;
	Timestamp createAt;
}
