package app.admin.course.domain;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Alias(value = "PartnerDTO")
public class PartnerDTO {
		String venId;
		String venPass;
		String venName;
		String venTel;
		String venNo;
		String venAddr;
		String venCeo;
		Timestamp venCdate;
		String venAcnt;
		String venAcntNo;
		String venOk;
		
		StartEndPageDTO2 startEndPageDTO;
		
		public PartnerDTO(String venId, String venPass, String venName,  String venTel, String venNo, String venAddr, String venCeo,
			   Timestamp venCdate, String venAcnt, String venAcntNo, String venOk) {
			this.venId = venId;
			this.venPass = venPass;
			this.venName = venName;
			this.venTel = venTel;
			this.venNo = venNo;
			this.venAddr = venAddr;
			this.venCeo = venCeo;
			this.venCdate = venCdate;
			this.venAcnt = venAcnt;
			this.venAcntNo = venAcntNo;
			this.venOk = venOk;
		}	
}
