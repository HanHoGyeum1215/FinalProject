package app.admin.intra.mapper;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import app.admin.intra.domain.IntraNoticeDTO;
import app.domain.StartEndPageDTO;

@Component
@Repository(value = "app.admin.intra.mapper.IntraNoticeMapper")
public interface IntraNoticeMapper {
	public void insertNotice(IntraNoticeDTO dto) throws Exception;
	public List<IntraNoticeDTO> viewNotice(StartEndPageDTO dto) throws Exception;
	public IntraNoticeDTO detailNotice(Integer notNo)throws Exception;
	public IntraNoticeDTO modifyNotice(Integer notNo) throws Exception; 
	public void updateNotice(IntraNoticeDTO dto)throws Exception;
	public void deleteNotice(IntraNoticeDTO dto)throws Exception;
	public int noticeCount()throws Exception;
	public int commuteCount()throws Exception;
	public void readCount(Integer notNo)throws Exception;
}
