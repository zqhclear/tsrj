package org.tsrj.service.member;

import java.util.Date;
import java.util.List;

import org.tsrj.model.member.Member;

public interface MemberService {
	
	public Member getMemberById(Long memberId);
	
	public Member getMemberByMobile(String mobile);
	
	public List<Member> getMemberListByRegister(Date startTime, Date endTime);
}
