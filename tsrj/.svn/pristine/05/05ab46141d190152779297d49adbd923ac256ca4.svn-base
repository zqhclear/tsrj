package org.tsrj.common.web.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tsrj.common.ConfigUtil;
import org.tsrj.common.contants.Constants;
import org.tsrj.common.domain.ResultBody;
import org.tsrj.common.encrypt.DESUtil;
import org.tsrj.common.encrypt.RSA;
import org.tsrj.common.enums.ResCodeEnums;
import org.tsrj.common.redis.MemberRedisUtil;
import org.tsrj.common.utils.DateUtils;
import org.tsrj.common.utils.MD5;
import org.tsrj.common.utils.StrUtils;
import org.tsrj.common.web.RequestHeaderEnums;
import org.tsrj.common.web.vo.UserSessionData;

import com.alibaba.fastjson.JSON;

public class RequestParamsUtil {
	
	
	private static Logger logger = LoggerFactory.getLogger(RequestParamsUtil.class);

	/**
	 * 除去数组中的空值和签名参数
	 *
	 * @param sArray
	 *            签名参数组
	 * @return 去掉空值与签名参数后的新签名参数组
	 */
	public static Map<String, String> paraFilter(Map<String, String[]> sArray) {
		Map<String, String> result = new HashMap<String, String>();
		if (sArray == null || sArray.size() <= 0) {
			return result;
		}
		for (String key : sArray.keySet()) {
			String value = buildStringArray(sArray.get(key));
			if (value.equals("") || key.equalsIgnoreCase("sign") || key.equalsIgnoreCase("signType")) {
				continue;
			}
			if (key.equals("token") && value.contains("/")) {//// 兼容GET提交，主要是文件上传，后面需优化
				try {
					value = URLEncoder.encode(value, "UTF-8");
				} catch (UnsupportedEncodingException e) {
				}
			}
			result.put(key, value);
		}
		return result;
	}

	private static String buildStringArray(String[] array) {
		StringBuilder s = new StringBuilder();
		for (String temp : array) {
			s.append(temp);
		}
		return s.toString();
	}

	/**
	 * 把数组所有元素排序，并按照“参数=参数值”的模式用“&”字符拼接成字符串
	 *
	 * @param params
	 *            需要排序并参与字符拼接的参数组
	 * @param encode
	 *            是否需要urlEncode
	 * @return 拼接后字符串
	 */
	public static String createLinkString(Map<String, String> params, boolean encode) {
		List<String> keys = new ArrayList<String>(params.keySet());
		Collections.sort(keys);
		String prestr = "";
		for (int i = 0; i < keys.size(); i++) {
			String key = keys.get(i);
			String value = params.get(key);
			if (encode) {
				try {
					value = URLEncoder.encode(value, "UTF-8");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}

			if (i == keys.size() - 1) {// 拼接时，不包括最后一个&字符
				prestr = prestr + key + "=" + value;
			} else {
				prestr = prestr + key + "=" + value + "&";
			}
		}

		return prestr;
	}
	
	public static String createLinkString2(Map params, boolean encode) {
		List<String> keys = new ArrayList<String>(params.keySet());
		Collections.sort(keys);
		String prestr = "";
		for (int i = 0; i < keys.size(); i++) {
			String key = keys.get(i);
			String value = (String)params.get(key);
			if (encode) {
				try {
					value = URLEncoder.encode(value, "UTF-8");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}

			if (i == keys.size() - 1) {// 拼接时，不包括最后一个&字符
				prestr = prestr + key + "=" + value;
			} else {
				prestr = prestr + key + "=" + value + "&";
			}
		}

		return prestr.replaceAll("\"", "");
	}

	/**
	 * 生成MD5签名结果
	 *
	 * @param sPara
	 *            要签名的数组
	 * @return 签名结果字符串
	 */
	public static String buildRequestByMD5(Map<String, String> sPara, String key) throws Exception {
		String prestr = createLinkString(sPara, false); // 把数组所有元素，按照“参数=参数值”的模式用“&”字符拼接成字符串
		return MD5.sign(prestr, key, "UTF-8");
	}
	
	/**
	 * 获得所有请求参数
	 * @param req
	 * @return
	 */
	public static Map<String, String> getParameterMap(final HttpServletRequest req) {
		Map<String, String> params = new HashMap<String, String>();
		Enumeration emu = req.getParameterNames();
		while (emu.hasMoreElements()) {
			String key = (String) emu.nextElement();
			String[] values = req.getParameterValues(key);
			if (values != null) {
				params.put(key, values[0]);
			}
		}
		return params;
	}

	public static UserSessionData getSessionData(HttpServletRequest request){
		UserSessionData sessionData = null;
		String token = request.getParameter(Constants.TOKEN);
		String reqTime = request.getHeader(RequestHeaderEnums.REQ_HEADER_REQUEST_TIME.getHeader());
		String _deviceType = request.getHeader(RequestHeaderEnums.REQ_HEADER_DEVICE_TYPE.getHeader());
		if (StringUtils.isNotBlank(token) && StringUtils.isNotBlank(reqTime)) {
			try {
				if (token.contains("/")) {// 兼容GET提交，主要是文件上传，后面需优化
					// encode编码
					token = URLEncoder.encode(token, Constants.CHARSET_UTF8);
				}
				// 动态Key，还是不够绝对安全，因为客户端时间和服务器时间有差异。后面再考虑优化
				String key = DateUtils.getStringDate(new Date(Long.parseLong(reqTime)), "ddHHmmss");
				// DES解密
				String tokenData = DESUtil.decrypt(URLDecoder.decode(token, Constants.CHARSET_UTF8), key);
				// RSA解密
				String userToken = new String(RSA.decryptByPrivateKey(Base64.decodeBase64(tokenData), ConfigUtil.getInstance().getSysEncryptRSAPrivateKey()), Constants.CHARSET_UTF8);
				//用户数据
				if(StrUtils.isNotBlank(userToken)){
					sessionData = JSON.parseObject(userToken, UserSessionData.class);
					request.setAttribute(Constants.USER_DATA, sessionData);
					Short deviceType = 0;
					String deviceTypeStr = request.getHeader(RequestHeaderEnums.REQ_HEADER_DEVICE_TYPE.getHeader());
					if (StrUtils.isNotBlank(deviceTypeStr)
							&& StrUtils.isNumeric(deviceTypeStr)) {
						deviceType= Short.valueOf(deviceTypeStr);
					}
					if(ConfigUtil.getInstance().isDev()){//测试环境
						return sessionData;
					}
					if (deviceType < 3) {
						String upToken = MemberRedisUtil.getMemberCache(sessionData.getId(), "token");
						if (!tokenData.equals(upToken)) {
							return null;
						}
					}
				}
			} catch (Exception ex) {
				logger.error("{}Token数据解释异常{}", _deviceType, ex);
			}
		}
		return sessionData;
	}
	
	/**
	 * 通知客户端
	 * @param response
	 * @throws IOException
	 */
	public static void resultData(HttpServletResponse response, ResCodeEnums resCode) throws IOException{
		ResultBody result = new ResultBody();
		result.setResCode(resCode.getResCode());
		result.setResMsg(resCode.getResMsg());
		response.setCharacterEncoding(Constants.CHARSET_UTF8);
		response.setContentType("application/json; charset="+Constants.CHARSET_UTF8);
		String jsonString = JSON.toJSONString(result);
		ServletOutputStream outputStream = response.getOutputStream();
		outputStream.write(jsonString.getBytes(Constants.CHARSET_UTF8));
	}
	
}
