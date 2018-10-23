package org.tsrj.api.wxcontroller;

import java.io.File;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.tsrj.api.controller.BaseController;
import org.tsrj.api.wxcontroller.vo.PermanentMaterialVO;
import org.tsrj.common.domain.ResultBody;
import org.tsrj.common.enums.ResCodeEnums;
import org.tsrj.common.utils.StringUtil;
import org.tsrj.service.wxchat.WXFileService;

import com.alibaba.fastjson.JSONObject;

/**
 * 
 * @author zhongqionghua
 * @data 2018/02/09
 * @des 微信公众号素材管理
 */
@RestController
@RequestMapping(value = "/wxFileManage", method = RequestMethod.POST)
public class WXFileController extends BaseController {
	
	@Resource
	private WXFileService wxFileService;
	/**
	 * @des 新增临时素材
	 */
	@RequestMapping("/uploadTemporaryFile")
	public ResultBody<JSONObject> uploadTemporaryFile(HttpServletRequest request){
		String type = ServletRequestUtils.getStringParameter(request, "type", null);
		String media = ServletRequestUtils.getStringParameter(request, "media", null);
		ResultBody<JSONObject> result = ResCodeEnums.verifyParam(type, media);
		if(!result.isSuccess()){
			return result;
		}
		return wxFileService.uploadTemporaryFile(type, media);
		
	}
	
	/**
	 * @des 获取临时素材
	 */
	@RequestMapping("/downloadTemporaryFile")
	public ResultBody<JSONObject> downloadTemporaryFile(HttpServletRequest request){
		ResultBody<JSONObject> result = new ResultBody<>();
		String mediaId = ServletRequestUtils.getStringParameter(request, "mediaId", null);
		if(StringUtil.isEmpty(mediaId)){
			result.setResMsg(ResCodeEnums.PARAM_ERROR.getResMsg());
			result.setResCode(ResCodeEnums.PARAM_ERROR.getResCode());
			return result;
		}
		return null;
		
	}
	/**
	 * @des 新增永久素材
	 */
	@RequestMapping("/uploadPermanentFile")
	public ResultBody uploadPermanentFile(HttpServletRequest request, PermanentMaterialVO permanentMaterialVO){
		return null;
	}
	/**
	 * @des 获取永久素材
	 */
	@RequestMapping("/downloadPermanentFile")
	public ResultBody downloadPermanentFile(HttpServletRequest request){
		return null;
	}
	/**
	 * @des 删除永久素材
	 */
	@RequestMapping("/delPermanentFile")
	public ResultBody delPermanentFile(HttpServletRequest request){
		return null;
	}
	/**
	 * @des 修改永久图文素材
	 */
	@RequestMapping("/updatePermanentImageFile")
	public ResultBody updatePermanentImageFile(HttpServletRequest request){
		return null;
	}
	/**
	 * @des 获取素材总数
	 */
	@RequestMapping("/getAmountFileNum")
	public ResultBody getAmountFileNum(HttpServletRequest request){
		return null;
	}
	/**
	 * @des 获取素材列表
	 */
	@RequestMapping("/getAmountFileList")
	public ResultBody getAmountFileList(HttpServletRequest request){
		return null;
	}
}
