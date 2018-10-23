package org.tsrj.common.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.tsrj.common.contants.Constants;


public class StrUtils extends StringUtils {
	
    /**
     * "*"
     */
    public static final String ASTERISK = "*";

	public final static String[] toArray(String str) {
		return toArrayByDelim(str, Constants.SPLIT);
	}

	public final static String[] toArrayByDelim(String str, String del) {
		String[] array = null;
		if (str != null && str.length() > 0 && del != null && del.length() > 0) {
			StringTokenizer st = new StringTokenizer(str, del);
			if (st != null && st.countTokens() > 0) {
				array = new String[st.countTokens()];
				int i = 0;
				while (st.hasMoreTokens()) {
					array[i++] = st.nextToken();
				}
			}
		}

		return array;
	}

	/**
	 * 获得性别
	 * @param idCard
	 * @return
	 */
	public static int getGenderByIdCard(String idCard) {
		if (isNotBlank(idCard)) {
			if (idCard.length() == 15) {
				int sex = Integer.parseInt(idCard.substring(14, 15));
				if (sex % 2 == 0) {
					return 2;
				}
				return 1;
			} else if (idCard.length() == 18) {
				int sex = Integer.parseInt(idCard.substring(16, 17));
				if (sex % 2 == 0) {
					return 2;
				}
				return 1;
			}
		}
		return 1;
	}
	
	/**
	 * 获得出生年月
	 * @param idCard
	 * @return
	 */
	public static Date getBirthdayByIdCard(String idCard){
		String data = "";
		if (idCard.length() == 18) {
			data = idCard.substring(0, 17);
		} else if (idCard.length() == 15) {
			data = idCard.substring(0, 6) + "19" + idCard.substring(6, 15);
		}
		String date = data.substring(6, 10)+"-"+data.substring(10, 12)+"-"+data.substring(12, 14);// 年份
		return DateUtils.getDateWithDateStr(date, DateUtils.YYYY_MM_DD);
	}
	
	/**
	 * 删除最后一个分隔符
	 * @param data
	 * @return
	 */
	public static String removeEndSplit(String data){
		return removeEndSplit(data, Constants.SPLIT);
	}
	/**
	 * 将标签列表 按照prefix 拼接字符串
	 * 最多显示tagSize（6）
	 * @param list
	 * @param prefix
	 * @return
	 */
	public static String strListToString(List<String> list, String prefix){
		StringBuffer value = new StringBuffer("");
		if(list != null && list.size() > 0){
			
			for(int i = 0; i <= list.size()-1; i++){
				String tag = list.get(i);
				value.append(tag).append(prefix);
			}
			return removeEndSplit(value.toString(), prefix);
		}
		return value.toString();
		
	}
	
	/**
	 * 字符集合转成以分隔符的字符串
	 * @param values
	 * @return
	 */
	public static String listConvertString(List<String> values){
		if(values == null || values.size() == 0){
			return null;
		}
		StringBuffer sb = new StringBuffer();
		for(String v : values){
			sb.append(v).append(Constants.SPLIT);
		}
		return removeEndSplit(sb.toString());
	}
	
	/**
	 * 删除最后一个分隔符
	 * @param data
	 * @return
	 */
	public static String removeEndSplit(String data, String prefix){
		if(isNoneEmpty(data)){
			if(data.endsWith(prefix)){
				return data.substring(0, data.length()-1);
			}
		}
		return data;
	}
	
	/**
	 * 判断对象是否为空
	 * @param obj
	 * @return
	 */
	public static boolean isNotEmptyObj(Object obj){
		if(obj == null){
			return false;
		}
		return isNoneBlank(obj.toString());
	}
	
	/**
	 * 判断值是否相等
	 * @param obj
	 * @param obj2
	 * @return
	 */
	public static boolean equalsObj(Object obj, Object obj2){
		if(obj != null && obj2 != null){
			if(isNotBlank(obj.toString()) && isNoneBlank(obj2.toString())){
				if(obj.equals(obj2)){
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * 判断是否为空.
	 */
	public static boolean isEmpty(Collection<?> collection) {
		return ((collection == null) || collection.isEmpty());
	}

	/**
	 * 判断是否为空.
	 */
	public static boolean isNotEmpty(Collection<?> collection) {
		return ((collection != null) && !(collection.isEmpty()));
	}
	
	 /**
     * 字符串 无规则打乱
     */
    public static String shuffle(String str)
    {
        List<String> list = Arrays.asList(str.split(""));
        Collections.shuffle(list);
        StringBuilder sb = new StringBuilder();
        for(String s : list)
        {
            sb.append(s);
        }
        return sb.toString();
    }
    
    /**
     * 用maskStr替换target字符，若传入的last为正数，则保留last位数字符不被替换，反之，则保留最后last位数的字符不被替换
     */
    public static String maskMidString(String target, String maskStr, int front, int last)
    {
        if(target == null)
        {
            return null;
        }
        int length = target.length() - Math.abs(front) - Math.abs(last);
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < length; i++)
        {
            sb.append(maskStr);
        }
        sb.insert(0, StrUtils.substring(target, 0, front));
        if(length > 0)
        {
            sb.append(StrUtils.substring(target, target.length() - Math.abs(last), target.length()));
        }
        return sb.toString();
    }

    /**
     * 用maskStr替换target字符，若传入的last为正数，则保留last位数字符不被替换，反之，则保留最后last位数的字符不被替换
     */
    public static String maskString(String target, String maskStr, int last)
    {
        if(target == null)
        {
            return null;
        }
        int length = target.length() - Math.abs(last);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < length; i++)
        {
            sb.append(maskStr);
        }
        if(last > 0)
        {
            sb.insert(0, StrUtils.substring(target, 0, last));
        }
        else
        {
            sb.append(StrUtils.substring(target, last));
        }
        return sb.toString();
    }

    /**
     * 用maskStr替换target字符，传入的front为保留的前几位，last为保留的最后几位，front和last应该大于0，否则取其绝对值
     */
    public static String maskString(String target, String maskStr, int front, int last)
    {
        if(target == null)
        {
            return null;
        }
        int length = target.length() - Math.abs(front) - Math.abs(last);
        int flength = target.length() - Math.abs(front);
        int nlength = length > 0 ? length : flength;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < nlength; i++)
        {
            sb.append(maskStr);
        }
        sb.insert(0, StrUtils.substring(target, 0, front));
        if(length > 0)
        {
            sb.append(StrUtils.substring(target, target.length() - Math.abs(last), target.length()));
        }
        return sb.toString();
    }
    
    /**
     * 用maskStr替换target字符，传入的front为保留的前几位，last为保留的最后几位，front和last应该大于0，否则取其绝对值
     *
     * @param count 中间被替换字符的个数
     */
    public static String maskString(String target, String maskStr, int front, int last, int count)
    {
        if(target == null)
        {
            return null;
        }
        int length = target.length() - Math.abs(front) - Math.abs(last);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < count; i++)
        {
            sb.append(maskStr);
        }
        sb.insert(0, StringUtils.substring(target, 0, front));
        if(length > 0)
        {
            sb.append(StringUtils.substring(target, target.length() - Math.abs(last), target.length()));
        }
        return sb.toString();
    }

    /**
     * 掩码 真实姓名
     */
    public static String maskTrueName(String trueName)
    {
        if(isNotBlank(trueName))
        {
            char[] chars = trueName.toCharArray();
            StringBuilder s = new StringBuilder();
            for(int i = 0; i < chars.length; i++)
            {
                if(i == 0)
                {
                    s.append(chars[i]);
                }
                else
                {
                    s.append(ASTERISK);
                }
            }
            return s.toString();
        }
        return "";
    }
    
    /**
     * 检查是否正确手机号
     */
    public static boolean isMobile(String mobile)
    {
        try
        {
            Pattern p = Pattern.compile(
                    "13[0-9]{9}$|14[5,7]{1}[0-9]{8}$|15[0-9]{9}$|17[0,6,7,8,3,1,2,4,5]{1}[0-9]{8}$|18[0-9]{9}");
            Matcher m = p.matcher(mobile);
            return m.matches();
        }
        catch(Exception ex)
        {
            return false;
        }
    }

    /**
     * 掩码 真实姓名
     */
    public static String maskTrueNameMiddleChar(String trueName)
    {
        if(isNotBlank(trueName))
        {
            if(trueName.length() == 2)
            {
                return maskMidString(trueName, ASTERISK, 0, 1);
            }
            else if(trueName.length() > 2)
            {
                return maskMidString(trueName, ASTERISK, 1, 1);
            }
            else
            {
                return ASTERISK;
            }
        }
        return "";
    }

    /**
     * 掩码 真实姓名
     */
    public static String maskFirstName(String trueName)
    {
        if(isNotBlank(trueName))
        {
            char[] chars = trueName.toCharArray();
            StringBuilder s = new StringBuilder();
            for(int i = 0; i < chars.length; i++)
            {
                if(i == 0)
                {
                    s.append(ASTERISK);
                }
                else
                {
                    s.append(chars[i]);
                }
            }
            return s.toString();
        }
        return "";
    }
    
    
    /**
     * 掩码，手机号码
     */
    public static String maskMobileCanNull(String target)
    {
        if(target == null)
        {
            return "";
        }
        return maskMidString(target, StrUtils.ASTERISK, 3, 4);
    }
    
    /**
     * 掩码，手机号码
     */
    public static String maskMobileCanNullNew(String target)
    {
        if(target == null)
        {
            return "";
        }
        return maskMidString(target, StrUtils.ASTERISK, 2, 3);
    }


    /**
     * 掩码，IP
     */
    public static String maskIp(String target)
    {
        if(StrUtils.isBlank(target))
        {
            return "";
        }
        int idx = target.lastIndexOf(".");
        if(idx > -1)
        {
            return maskMidString(target, StrUtils.ASTERISK, idx + 1, 0);
        }
        return maskMidString(target, StrUtils.ASTERISK, target.length() - 1, 1);
    }

    /**
     * 处理后的身份证号 例如：330621******2212
     */
    public static String maskIdentityNumber(String identityNumber)
    {
        return StrUtils.maskString(identityNumber, StrUtils.ASTERISK, 6, 4, 6);
    }

    /**
     * 处理后的身份证号 例如：330*********2212
     */
    public static String maskIdentityNumber2(String identityNumber)
    {
        return StrUtils.maskString(identityNumber, StrUtils.ASTERISK, 3, 4, 9);
    }

    /**
     * 掩码 银行卡号
     */
    public static String maskBankCodeNumber(String bankNumber)
    {
        return StrUtils.maskString(bankNumber, StrUtils.ASTERISK, 5, 4, 4);
    }
    
    public static String encodeUTF(String str)
    {
        String temp = "";
        if(isNotBlank(str))
        {
            try
            {
                temp = URLEncoder.encode(str, "UTF-8");
            }
            catch(UnsupportedEncodingException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return temp;
    }
    
    public static String htmlEncode(String source)
    {
        if(source == null)
        {
            return null;
        }
        String html;
        StringBuilder buffer = new StringBuilder();
        for(int i = 0; i < source.length(); i++)
        {
            char c = source.charAt(i);
            switch(c)
            {
                case '<':
                    buffer.append("&lt;");
                    break;
                case '>':
                    buffer.append("&gt;");
                    break;
                case '&':
                    buffer.append("&amp;");
                    break;
                case '"':
                    buffer.append("&quot;");
                    break;
                case 10:
                case 13:
                    break;
                default:
                    buffer.append(c);
            }
        }
        html = buffer.toString();
        return html;
    }

    public static String htmlDecode(String str)
    {
        if(StringUtils.isEmpty(str))
        {
            return "";
        }
        String _str = str.replaceAll("&amp;", "&");
        _str = _str.replaceAll("&quot;", "\"");
        _str = _str.replaceAll("&gt;", ">");
        _str = _str.replaceAll("&lt;", "<");
        return _str;
    }

    /**
        * 字符串后面补充字符
        *
        * @param str    要补充字符的字符串
        * @param length 小于这个长度就补充字符
        * @param c      填充字符
        */
       public static String fillRightCharSequence(String str, int length, char c)
       {
           StringBuilder sBuilder = new StringBuilder();
           sBuilder.append(str);
           if(str.length() < length)
           {
               int n = length - str.length();
               for(int i = 0; i < n; i++)
               {
                   sBuilder.append(c);
               }
           }
           return sBuilder.toString();
       }
       

       public static String replace(String text, Map<String, ?> map)
       {
           return replace(text, "\\{([\\w\\.\\-_]*)\\}", map);
       }

       /**
        * 替换给定的正则表达式中的的字符串.
        */
       public static String replace(String text, String regex, Map<String, ?> map)
       {
           Pattern pat = Pattern.compile(regex);
           Matcher mat = pat.matcher(text);
           String returnText = text;
           while(mat.find())
           {
               String name = mat.group(1);
               if(map.containsKey(name))
               {
                   returnText = returnText.replace(mat.group(), ObjectUtils.defaultIfNull(map.get(name), "").toString());
               }
           }
           return returnText;
       }
       

       /**
        * 首字母小写
        */
       public static String firstLowerCase(String str)
       {
           if(isBlank(str))
           {
               return str;
           }
           char chars = str.charAt(0);
           if(chars >= 'A' && chars <= 'Z')
           {
               String temp = String.valueOf(chars);
               return str.replaceFirst(temp, temp.toLowerCase());
           }
           return str;
       }


       /**
        * 首字母大写
        */
       public static String firstUpperCase(String str)
       {
           if(isBlank(str))
           {
               return str;
           }
           char chars = str.charAt(0);
           if(chars >= 'A' && chars <= 'Z')
           {
               String temp = String.valueOf(chars);
               return str.replaceFirst(temp, temp.toUpperCase());
           }
           return str;
       }
}
