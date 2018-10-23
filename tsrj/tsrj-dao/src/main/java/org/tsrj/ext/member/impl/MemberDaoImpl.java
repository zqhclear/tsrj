package org.tsrj.ext.member.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.tsrj.common.utils.CollectionUtils;
import org.tsrj.dao.member.MemberMapper;
import org.tsrj.ext.member.MemberDao;
import org.tsrj.model.member.Member;
import org.tsrj.model.member.MemberConditions;

@Repository
public class MemberDaoImpl implements MemberDao {
	
	@Resource
	private MemberMapper memberMapper;
	
	@Override
	public Member getMemberById(Long memberId) {
		MemberConditions conditions = new MemberConditions();
		conditions.createCriteria().andIdEqualTo(memberId);
		List<Member> memberList = memberMapper.selectByExample(conditions);
		if(CollectionUtils.isEmpty(memberList)){
			return null;
		}
		return memberList.get(0);
	}

	@Override
	public Member getMemberByMobile(String mobile) {
		MemberConditions conditions = new MemberConditions();
		conditions.createCriteria().andMobileEqualTo(mobile);
		List<Member> memberList = memberMapper.selectByExample(conditions);
		if(CollectionUtils.isEmpty(memberList)){
			return null;
		}
		return memberList.get(0);
	}

	@Override
	public List<Member> getMemberListByRegister(Date startTime, Date endTime) {
		MemberConditions conditions = new MemberConditions();
		conditions.createCriteria().andCreateTimeBetween(startTime, endTime);
		return memberMapper.selectByExample(conditions);
	}

}
