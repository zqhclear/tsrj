package org.tsrj.service.member.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.tsrj.ext.member.MemberDao;
import org.tsrj.model.member.Member;
import org.tsrj.service.member.MemberService;

@Service
public class MemberServiceImpl implements MemberService {

	@Resource
	private MemberDao memberDao;
	
	@Override
	public Member getMemberById(Long memberId) {
		return memberDao.getMemberById(memberId);
	}

	@Override
	public Member getMemberByMobile(String mobile) {
		return memberDao.getMemberByMobile(mobile);
	}

	@Override
	public List<Member> getMemberListByRegister(Date startTime, Date endTime) {
		return memberDao.getMemberListByRegister(startTime, endTime);
	}

}
