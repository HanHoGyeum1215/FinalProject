package app.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserIdChangeDTO {
	String userName;
	String userEmail;
	String userTel;
}
