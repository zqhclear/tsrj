/**
 * @author zhubingbing
 * @date   2017年4月5日 下午5:25:36   
 */  
package org.tsrj.common.validator;

import org.apache.commons.collections.CollectionUtils;
import org.tsrj.common.utils.StrUtils;
import org.tsrj.common.utils.StringUtil;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.groups.Default;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * @author zhubingbing
 * @date   2017年4月5日 下午5:25:36   
 */
public class ValidatorUtil {

	public static boolean checkLoginPassword(String LoginPassword){
		if(StrUtils.isBlank(LoginPassword)){
			return false;
		}
		String patternStr = "^([A-Z]|[a-z]|[0-9]){6,16}$";
		return Pattern.matches(patternStr, LoginPassword);
	}

	public static boolean checkPayPassword(String payPassword){
		if(StrUtils.isBlank(payPassword)){
			return false;
		}
		return Pattern.matches("^\\d{6}$", payPassword);
	}

	public static boolean checkTrueName(String trueName){
		if(StrUtils.isBlank(trueName) || trueName.length() > 20){
			return false;
		}
		return true;
	}

	public static boolean checkMobileCode(String mobileCode){
		if(StrUtils.isBlank(mobileCode)){
			return false;
		}
		String patternStr = "^\\d{6}$";
		return Pattern.matches(patternStr, mobileCode);
	}

	public static boolean checkBankCard(String bankCard){
		if(StrUtils.isBlank(bankCard)){
			return false;
		}
		String patternStr = "^\\d{15,30}$";
		return Pattern.matches(patternStr, bankCard);
	}

	public static boolean checkAddress(String address){
		if(StrUtils.isBlank(address) || address.length() > 200){
			return false;
		}
		return true;
	}

//	public static boolean checkNickName(String nickName){
//		String nickNameStr = ConfigUtil.getInstance().getMemberNickNameSensitive();
//		if (StrUtils.isNotBlank(nickNameStr)) {
//			String[] nickNames = nickNameStr.split(",");
//			for (String s : nickNames) {
//				if (nickName.indexOf(s) != -1) {
//					return false;
//					}
//			}
//		}
//		Boolean isSensitive = NickNameFilter.nickNameFilter(nickName);
//		if (isSensitive) {
//			return false;
//		}
//		return true;
//	}

	/**
	 * 使用validator来检测bean中的参数是否合法
	 * 如果不合法，返回错误信息；否则返回空
	 * 注：当属性被@NotIsValidator注解修饰时，表明不需要被验证
	 * @param obj
	 * @return
	 */
	private static String validatorBeanForList(Object obj) {
		Class clazz = obj.getClass();
		Field[] fields = clazz.getDeclaredFields();	//获取obj的所有的属性值
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		List<String> errorMsgList = new ArrayList<>();
		try {
			for (Field field : fields) {
				field.setAccessible(true); // 设置些属性是可以访问的
				if(field.getAnnotation(NotIsValidator.class) != null){	//添加了@NotIsValidator的属性不需要被校检
					continue;
				}
				Object val = field.get(obj); // 得到obj对象在此属性的值
                if(val instanceof List){	//当属性中存在List时，递归检测
					String errorMsg = validatorList((List)val);
					if(StringUtil.isNotEmpty(errorMsg)){
						return errorMsg;
					}
					continue;
                }
                if(val == null){
                	continue;
				}
				Set<ConstraintViolation<Object>> errorSet = validator.validate(val, Default.class);	//当val为空时，会报错
				if (CollectionUtils.isNotEmpty(errorSet)) {
					for (ConstraintViolation<Object> cv : errorSet) {
						//这里循环获取错误信息，可以自定义格式
                        errorMsgList.add(cv.getMessage());
					}
				}
			}
			if(CollectionUtils.isNotEmpty(errorMsgList)){
				return errorMsgList.toString();
			}
		} catch (Exception e) {
		}
		return null;
	}

	private static String validatorFiled(List fieldList, Validator validator){
		for(Object obj : fieldList){
			String errorMsg = validatorObj(obj, validator);
			if(StringUtil.isNotEmpty(errorMsg)){
				return errorMsg;
			}
		}
		return null;
	}

	/**
	 * 验证list类型bean中的参数是否合法
	 * 可递归查询
	 * @param list
	 * @return
	 */
	public static String validatorList(List list){
		if(CollectionUtils.isEmpty(list)){
			return null;
		}
		for(Object obj : list){
			//先验证obj参数是否合规
			String errorMsg = validatorBean(obj);
			if(StringUtil.isNotEmpty(errorMsg)){
				return errorMsg;
			}
			//再验证obj中的参数中的参数是否合规（双层）
			errorMsg = validatorBeanForList(obj);
			if(StringUtil.isNotEmpty(errorMsg)){
				return errorMsg;
			}
		}
		return null;
	}

	/**
	 * 验证对象的参数是否合规，可传递多个对象（数组）
	 * @param objs
	 * @return
	 */
	public static String validatorBean(Object... objs){
		if(objs == null || objs.length <= 0)return null;
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		for(Object obj : objs){
			String errorMsg = validatorObj(obj, validator);
			if(StringUtil.isNotEmpty(errorMsg)){
				return errorMsg;
			}
		}
		return null;
	}

	private static String validatorObj(Object obj, Validator validator){
		List<String> errorMsgList = new ArrayList<>();
		Set<ConstraintViolation<Object>> errorSet = validator.validate(obj, Default.class);
		if (CollectionUtils.isNotEmpty(errorSet)) {
			for (ConstraintViolation<Object> cv : errorSet) {
				//这里循环获取错误信息，可以自定义格式
				errorMsgList.add(cv.getMessage());
			}
		}
		if(CollectionUtils.isNotEmpty(errorMsgList)){
			return errorMsgList.toString();
		}
		return null;
	}

}
