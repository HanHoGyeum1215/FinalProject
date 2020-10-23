package app.admin.intra.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IntraDepartmentDTO {
	Long depNo;
	String depName;
}
