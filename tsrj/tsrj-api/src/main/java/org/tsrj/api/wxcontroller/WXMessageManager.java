/**
 * 
 */
package org.tsrj.api.wxcontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.tsrj.api.controller.BaseController;

/**
 * @desc 微信消息管理
 * @author zhongqionghua
 * @date 2018年2月9日
 */
@RestController
@RequestMapping(value = "/wxMessageManager", method = RequestMethod.POST)
public class WXMessageManager extends BaseController {
	
	/**
	 * @desc 接收普通消息 
	 * 当普通微信用户向公众账号发消息时，
	 * 微信服务器将POST消息的XML数据包到开发者填写的URL上。
	 */
	/*@RequestMapping("/recieveMessage")
	public ResultBody recieveMessage(HttpServletRequest request){
		
	}*/
	
}
