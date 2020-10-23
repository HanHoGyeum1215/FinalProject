package app.admin.matching.domain;



import java.sql.Date;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventDTO {
	Long eveNo;
	String venId;
	String eveLoc;
	Date eveDate;
	Long eveMxCnt;
	String eveSubject;
	String eveContent;
	String eveOriginalImage;
	String eveStoreImage;
	Long eveApplicant;
	public EventDTO(String eveOriginalImage, String eveStoreImage) {
		super();
		this.eveOriginalImage = eveOriginalImage;
		this.eveStoreImage = eveStoreImage;
	}
	
	

}
