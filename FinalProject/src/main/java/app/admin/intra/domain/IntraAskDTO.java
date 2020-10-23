package app.admin.intra.domain;

import java.sql.Timestamp;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IntraAskDTO {

	Integer askNo;
	String empId;
	String askSub;
	String askCont;
	Timestamp askDate;
	Integer askCount;
	String askOriginFile;
	String askStoreFile;
	Long askSize;
	
	private List<IntraAnswerDTO> answerlist;
}
