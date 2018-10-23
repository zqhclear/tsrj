package org.tsrj.service.wxchat.impl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.tsrj.service.wxchat.WXChatService;
import org.tsrj.service.wxchat.utils.WXChatRequestUtil;

@Service
public class WXChatServiceImpl implements WXChatService {

	@Override
	public void responseWXChat(HttpServletRequest request, HttpServletResponse response) {
		String token = "zhongqionghua";

        // 微信加密签名
        String signature = request.getParameter("signature");
        // 时间戳
        String timestamp = request.getParameter("timestamp");
        // 随机数
        String nonce = request.getParameter("nonce");
        // 随机字符串
        String echostr = request.getParameter("echostr");
        /*String[] params = new String[]{token, timestamp, nonce};
        Arrays.sort(params);
        StringBuffer stringBuffer = new StringBuffer();
        for (int i =0 ;i<params.length;i++) {
            stringBuffer.append(params[i]);
        }
        String serverSign = WXChatRequestUtil.getSha1(stringBuffer.toString());
        if (Objects.equals(serverSign, signature)) {*/
            try {
                PrintWriter printWriter = response.getWriter();
                printWriter.print(echostr);
            } catch (IOException e) {
                e.printStackTrace();
            }
        //}
	}

}
