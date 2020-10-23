package app.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPwChangeDTO {
	String userId;
	String userName;
	String userEmail;
	String newPw;
}
