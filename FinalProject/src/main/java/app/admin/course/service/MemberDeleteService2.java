package app.admin.course.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import app.admin.course.mapper.MemberMapper2;

@Component
@Service
public class MemberDeleteService2 {
    @Autowired
    MemberMapper2 memberMapper;
	
	public void memberDelete(String memId) throws Exception{
		memberMapper.memberDelete(memId);
	}		

}
