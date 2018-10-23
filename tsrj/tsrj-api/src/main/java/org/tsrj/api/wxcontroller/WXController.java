package org.tsrj.api.wxcontroller;

import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tsrj.api.controller.BaseController;
import org.tsrj.service.wxchat.WXChatService;

@RestController
@RequestMapping("/wxChat")
public class WXController extends BaseController {
	
	@Resource
	private WXChatService wxChatService;
	
	@RequestMapping("/responseWX")
	public void responseWX(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException{
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		wxChatService.responseWXChat(request, response);
	}
}
