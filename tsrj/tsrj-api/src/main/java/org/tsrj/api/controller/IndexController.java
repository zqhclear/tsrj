package org.tsrj.api.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.tsrj.common.domain.ResultBody;
import org.tsrj.model.member.Member;
import org.tsrj.service.member.MemberService;

@RestController
@RequestMapping(value = "/index", method = RequestMethod.POST)
public class IndexController extends BaseController {
	private static Logger logger = LoggerFactory.getLogger(IndexController.class);
	
	@Resource
	private MemberService memberService;
	
	@RequestMapping("/index")
	public ResultBody<Member> index(HttpServletRequest request){
		logger.info("index METHOD !");
		ResultBody<Member> result = new ResultBody<>();
		Long memberId = ServletRequestUtils.getLongParameter(request, "memberId", 0L);
		Member member = memberService.getMemberById(memberId);
		result.setData(member);
		return result;
	}
}
