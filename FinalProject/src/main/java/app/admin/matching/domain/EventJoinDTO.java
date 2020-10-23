package app.admin.matching.domain;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventJoinDTO {
	String joNo;
	String eveNo;
	Timestamp joDate;
	String memId;
}
