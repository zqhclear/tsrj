package org.tsrj.common.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

//import org.apache.commons.httpclient.methods.GetMethod;
//import org.apache.commons.httpclient.util.HttpURLConnection;
import org.apache.commons.lang3.StringUtils;
//import org.htmlparser.Node;
//import org.htmlparser.NodeFilter;
//import org.htmlparser.Parser;
//import org.htmlparser.filters.AndFilter;
//import org.htmlparser.filters.CssSelectorNodeFilter;
//import org.htmlparser.filters.HasParentFilter;
//import org.htmlparser.filters.TagNameFilter;
//import org.htmlparser.util.NodeList;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.tsrj.common.ConfigUtil;

import com.google.common.collect.ImmutableMap;

public class Tools
{
    // 签名版本名称
    public static final String SIGN_VERSION_NAME = "sign_version";

    // 签名类型名称
    public static final String SIGN_TYPE_NAME = "sign_type";

    // 签名名称
    public static final String SIGN_NAME = "sign";

    /**
     * 把数组所有元素排序，并按照“参数=参数值”的模式用“&”字符拼接成字符串
     *
     * @param params 需要排序并参与字符拼接的参数组
     * @param encode 是否需要urlEncode
     * @return 拼接后字符串
     */
    public static String createLinkString(Map<String, String> params, boolean encode)
    {
        List<String> keys = new ArrayList<>(params.keySet());
        Collections.sort(keys);
        String prestr = "";
        String charset = params.get("inputCharset");
        for(int i = 0; i < keys.size(); i++)
        {
            String key = keys.get(i);
            String value = params.get(key);
            if(encode)
            {
                try
                {
                    value = URLEncoder.encode(URLEncoder.encode(value, charset), charset);
                }
                catch(UnsupportedEncodingException e)
                {
                    e.printStackTrace();
                }
            }
            if(i == keys.size() - 1)
            {// 拼接时，不包括最后一个&字符
                prestr = prestr + key + "=" + value;
            }
            else
            {
                prestr = prestr + key + "=" + value + "&";
            }
        }

        return prestr;
    }

    /**
     * request 转map
     */
    @SuppressWarnings("unchecked")
    public static Map getParameterMap(HttpServletRequest request, boolean isFilter)
    {
        // 参数Map
        Map properties = request.getParameterMap();
        // 返回值Map
        Map returnMap = new HashMap();
        Iterator entries = properties.entrySet().iterator();
        Map.Entry entry;
        String name;
        String value = "";
        while(entries.hasNext())
        {
            entry = (Map.Entry) entries.next();
            name = (String) entry.getKey();
            if(isFilter)
            {
                if(!name.equals("sign") && !name.equals("signType") && !name.equals("signVersion"))
                {
                    Object valueObj = entry.getValue();
                    if(null == valueObj)
                    {
                        value = "";
                    }
                    else if(valueObj instanceof String[])
                    {
                        String[] values = (String[]) valueObj;
                        for(String value1 : values)
                        {
                            value = value1 + ",";
                        }
                        value = value.substring(0, value.length() - 1);
                    }
                    else
                    {
                        value = valueObj.toString();
                    }
                    returnMap.put(name, value);
                }
            }
            else
            {
                Object valueObj = entry.getValue();
                if(null == valueObj)
                {
                    value = "";
                }
                else if(valueObj instanceof String[])
                {
                    String[] values = (String[]) valueObj;
                    for(String value1 : values)
                    {
                        value = value1 + ",";
                    }
                    value = value.substring(0, value.length() - 1);
                }
                else
                {
                    value = valueObj.toString();
                }
                returnMap.put(name, value);
            }
        }
        return returnMap;
    }

    /**
     * 获取单个文件的MD5值！
     *
     * @param file 需要计算MD5value的文件路径
     * @return 文件的MD5zhaiya
     */
    public static String getFileMD5(File file)
    {
        if(!file.isFile())
        {
            return null;
        }
        MessageDigest digest;
        FileInputStream in;
        byte buffer[] = new byte[1024];
        int len;
        try
        {
            digest = MessageDigest.getInstance("MD5");
            in = new FileInputStream(file);
            while((len = in.read(buffer, 0, 1024)) != -1)
            {
                digest.update(buffer, 0, len);
            }
            in.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
        BigInteger bigInt = new BigInteger(1, digest.digest());
        return bigInt.toString(16);
    }

    /**
     * 生成订单编号 生成规则:业务编号 + 年月日(5位) + 当日秒数(5位) + 随机数(2位) + 用户ID后4位
     *
     * @param businessCode 业务编号
     * @param memberId     用户ID
     */
    public static String generateOrderCode(String businessCode, Long memberId)
    {
        StringBuilder sb = new StringBuilder();
        sb.append(businessCode);
        Date now = new Date();
        String sdate = new SimpleDateFormat("yMMdd").format(now);
        sb.append(sdate.substring(sdate.length() - 5));
        String seconds = String.valueOf(now.getTime() / 1000);
        sb.append(seconds.substring(seconds.length() - 5));
        int random = (int) (Math.random() * 100);
        sb.append(random < 10 ? "0" + random : random);
        String smemberId = String.valueOf(memberId);
        if(smemberId.length() < 4)
        {
            for(int i = smemberId.length(); i < 4; i++)
            {
                sb.append("0");
            }
            sb.append(smemberId);
        }
        else
        {
            sb.append(smemberId.substring(smemberId.length() - 4));
        }
        return sb.toString();
    }

    /**
     * 返回图片的完整url
     */
    public static String getImageFillUrl(String uri)
    {
        if(org.apache.commons.lang3.StringUtils.isEmpty(uri))
        {
            return "";
        }
        return ConfigUtil.getInstance().getCdnOssUrl() + uri;
    }

    /**
     * 返回图片的完整url
     */
    public static String getImageStaticWebUrl(String uri)
    {
        if(org.apache.commons.lang3.StringUtils.isEmpty(uri))
        {
            return "";
        }
        return ConfigUtil.getInstance().getQiNiuImgPath() + uri;
    }

    /**
     * 将数组类型转变
     */
    public static Long[] convert(long[] ary)
    {
        Long[] nAry = new Long[ary.length];
        for(int i = 0; i < ary.length; i++)
        {
            nAry[i] = ary[i];
        }
        return nAry;
    }

    /**
     * 将数组类型转变
     */
    public static Long[] convertLong(String[] ary)
    {
        Long[] nAry = new Long[ary.length];
        for(int i = 0; i < ary.length; i++)
        {
            nAry[i] = Long.valueOf(ary[i]);
        }
        return nAry;
    }

    /**
     * 返回从请求中获取的图片base64字符串
     */
    public static List<String> getRequestBase64Images(HttpServletRequest req)
    {
        List<String> images = new ArrayList<>();
        int i = 0;
        while(true)
        {
            try
            {
                String image = ServletRequestUtils.getRequiredStringParameter(req, "images[" + (i++) + "]");
                if(org.apache.commons.lang3.StringUtils.isEmpty(image))
                {
                    break;
                }
                images.add(image);
            }
            catch(ServletRequestBindingException e)
            {
                break;
            }
        }
        return images;
    }

    /**
     * 根据身份证计算年龄并返回
     */
    public static double calAgeByIdentity(String identity)
    {
        Date birthday = IDCard.getDateOfBirth(identity);
        int intervalDays = DateUtils.daysBetween(birthday, new Date());
        return intervalDays / 365d;
    }

    /**
     * 判断公司是否存在
     */
    public static boolean hasCompany(String companyName) throws Exception
    {
//        String url = "http://www.qichacha.com/search?key={0}&index=2";
//        URLConnection urlConn = new HttpURLConnection(new GetMethod(), new URL(url));
//        urlConn.setReadTimeout(15 * 1000);
//        Parser parser = new Parser(MessageFormat.format(url, companyName));
//        parser.setEncoding("utf-8");
//        NodeFilter parentFilter = new HasParentFilter(new CssSelectorNodeFilter(".clear"));
//        NodeFilter cssFilter = new CssSelectorNodeFilter(".name");
//        NodeFilter tagFilter = new TagNameFilter("span");
//        NodeFilter filter = new AndFilter(new NodeFilter[]{tagFilter, cssFilter, parentFilter});
//        NodeList list = parser.extractAllNodesThatMatch(filter);
//        for(int i = 0; i < list.size(); i++)
//        {
//            Node tag = list.elementAt(i);
//            if(StringUtils.equals(tag.toPlainTextString(), companyName))
//            {
//                return true;
//            }
//        }
        return false;
    }

    public static String getHttpReqQueryString(HttpServletRequest req)
    {
        StringBuilder sb = new StringBuilder();
        Enumeration<String> enums = req.getParameterNames();
        while(enums.hasMoreElements())
        {
            String key = enums.nextElement();
            String[] values = req.getParameterValues(key);
            String value = values == null ? "" : StringUtils.join(values, ",");
            sb.append(key).append("=").append(value).append("&");
        }
        if(sb.length() > 0)
        {
            sb.replace(sb.length() - 1, sb.length(), "");
        }
        return sb.toString();
    }


    /**
     * url添加参数
     */
    public static String addUrlParams(String url, String name, String value)
    {
        if(StringUtils.isBlank(url))
        {
            return "";
        }
        String sign = !url.contains("?") ? "?" : "&";
        return url + sign + name + "=" + value;
    }
    
    /**
     * url添加参数
     */
    public static String addUrlParams(String url, String name1, String value1, String name2, String value2)
    {
        return addUrlParams(url, ImmutableMap.of(name1, value1, name2, value2));
    }
    
    /**
     * url添加参数
     */
    public static String addUrlParams(String url, String name1, String value1, String name2, String value2, String name3, String value3)
    {
        return addUrlParams(url, ImmutableMap.of(name1, value1, name2, value2, name3, value3));
    }
    
    /**
     * url添加参数
     */
    public static String addUrlParams(String url, String name1, String value1, String name2, String value2, String name3, String value3, String name4, String value4)
    {
        return addUrlParams(url, ImmutableMap.of(name1, value1, name2, value2, name3, value3, name4, value4));
    }


    /**
     * url添加参数
     */
    public static String addUrlParams(String url, Map<String, String> params)
    {
        if(StringUtils.isBlank(url))
        {
            return "";
        }
        else if(params == null || params.isEmpty())
        {
            return url;
        }
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String, String> entry : params.entrySet())
        {
            if(sb.length() > 0)
            {
                sb.append("&");
            }
            sb.append(entry.getKey()).append("=").append(entry.getValue());
        }
        String sign = !url.contains("?") ? "?" : "&";
        return url + sign + sb.toString();
    }

    /**
     * 比较版本号 如果version1大于version2返回1, 如果version1小于version2返回-1,
     * 如果version1等于version2返回0
     */
    public static int compareVersion(String version1, String version2)
    {
        String v1 = version1.replaceAll("\\.", "");
        String v2 = version2.replaceAll("\\.", "");
        v1 = StrUtils.fillRightCharSequence(v1, 10, '0');
        v2 = StrUtils.fillRightCharSequence(v2, 10, '0');
        Long vl1 = Long.parseLong(v1);
        Long vl2 = Long.parseLong(v2);
        return vl1.compareTo(vl2);
    }
    
    
    /**
     * 返回Web页面的完整url
     * @param uri
     * @return
     */
    public static String getWebUrl(String uri){
    	if(StringUtils.isEmpty(uri)){
    		return "";
    	}
    	return ConfigUtil.getInstance().getWebUrl() + uri;
    }
    
    /** 
     * 数据格式化
     * @param num
     * @param partten
     * @return      
     * String      
     */  
    public static String numberFormat(Number num, String partten){
    	DecimalFormat f = new DecimalFormat(partten);
		return f.format(num);
    }
    
    /** 
     * 通过用户id获取表序号
     * @param memberId
     * @return      
     * Long      
     */  
    public static Long generateTableNoByMemberId(Long memberId){
    	if(memberId == null || memberId < 10000000){
    		return 1L;
    	}
		return ((memberId - 1000000000) / 100000) + 1;
    }
    
    /** 
     * 校验指纹余额提现
     * @return      
     * boolean      
     */  
    public static boolean checkBalanceWithdrawFinger(String fingerPsw,String mobile){
    	if(StringUtils.isBlank(fingerPsw) || fingerPsw.length() != 17){
    		return false;
    	}
    	String fingerPswSub = fingerPsw.substring(0, 3) + fingerPsw.substring(8, 11);
    	String mobileSub = mobile.substring(0, 3) + mobile.substring(8, 11);
    	if(fingerPswSub.equals(mobileSub)){
    		return true;
    	}
		return false;
    }
    
    /** 
     * 将IP转化为整形字符串
     * 比如：127.0.0.1 》 127000000111
     * @param ip
     * @return      
     * String      
     */  
    public static String formatIpToInt(String ip){
    	String formatIp = "";
    	String[] nums = ip.split("\\.");
    	for (int i = 0; i < nums.length; i++) {
    		int n = 3 - nums[i].length();
    		for (int j = 0; j < n; j++) {
    			formatIp += "0";
    		}
    		formatIp += nums[i];
		}
    	return formatIp;
    }
}
