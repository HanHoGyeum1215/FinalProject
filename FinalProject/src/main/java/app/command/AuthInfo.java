package app.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthInfo {
	private String id;
	private String email;
	private String name;
	private String pw;
	private String condition;
	
}
