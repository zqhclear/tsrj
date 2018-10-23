package org.tsrj.common.httpclient.httpclient.common.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.tsrj.common.utils.StrUtils;


/** 
 * 字符串简易工具类
 * 
 * @author zhognqionghua
 * @date 2018年02月028日 下午6:31:03 
 * @version 1.0 
 */
public class StringUtil {

	/**
	 * 通过正则表达式获取内容
	 * 
	 * @param regex		正则表达式
	 * @param from		原字符串
	 * @return
	 */
	public static String[] regex(String regex, String from){
		Pattern pattern = Pattern.compile(regex); 
		Matcher matcher = pattern.matcher(from);
		List<String> results = new ArrayList<String>();
		while(matcher.find()){
			for (int i = 0; i < matcher.groupCount(); i++) {
				results.add(matcher.group(i+1));
			}
		}
		return results.toArray(new String[]{});
	}
	

    /**
     * 根据身份证获得性别 性别：(2:女，1：男,-1:保密)
     */
    public static Short getSexByIdentityNumber(String identityNumber)
    {
        if(StrUtils.isNotBlank(identityNumber))
        {
            if(identityNumber.length() == 15)
            {
                int sex = Integer.parseInt(identityNumber.substring(14, 15));
                if(sex % 2 == 0)
                {
                    return 2;
                }
                return 1;
            }
            else if(identityNumber.length() == 18)
            {
                int sex = Integer.parseInt(identityNumber.substring(16, 17));
                if(sex % 2 == 0)
                {
                    return 2;
                }
                return 1;
            }
        }
        return 0;
    }
	
}
