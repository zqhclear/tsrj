/**
 * @author zhubingbing
 * @date   2017年3月29日 下午5:38:05   
 */  
package org.tsrj.common.validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tsrj.common.utils.IDCard;
import org.tsrj.common.utils.StrUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 校验身份证号
 * @author zhubingbing
 * @date   2017年3月29日 下午5:38:05   
 */
public class IsIdentityNumberValidator implements ConstraintValidator<IsIdentityNumber, String> {

	Logger logger = LoggerFactory.getLogger(IsIdentityNumberValidator.class);
	
	@Override
	public void initialize(IsIdentityNumber constraintAnnotation) {
		//初始化，得到注解数据
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		String result = null;
		try {
			result = IDCard.IDCardValidate(value);
		} catch (Exception e) {
			logger.error("请输入合法的身份证号", e);
		}
		if(StrUtils.isNotBlank(result)){
			return false;
		}
		return true;
	}

}
