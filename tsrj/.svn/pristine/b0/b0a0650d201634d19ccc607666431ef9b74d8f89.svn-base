package org.tsrj.dao.member;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.tsrj.model.member.Member;
import org.tsrj.model.member.MemberConditions;

public interface MemberMapper {
    int countByExample(MemberConditions example);

    int deleteByExample(MemberConditions example);

    int deleteByPrimaryKey(Long id);

    int insert(Member record);

    int insertSelective(Member record);

    List<Member> selectByExample(MemberConditions example);

    Member selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Member record, @Param("example") MemberConditions example);

    int updateByExample(@Param("record") Member record, @Param("example") MemberConditions example);

    int updateByPrimaryKeySelective(Member record);

    int updateByPrimaryKey(Member record);
}