/**
 * @author zhubingbing
 * @date   2017年3月29日 下午5:38:05   
 */  
package org.tsrj.common.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 校验手机验证码
 * @author zhubingbing
 * @date   2017年3月29日 下午5:38:05   
 */
public class IsMobileCodeValidator implements ConstraintValidator<IsMobileCode, String> {

	
	@Override
	public void initialize(IsMobileCode constraintAnnotation) {
		//初始化，得到注解数据
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		return ValidatorUtil.checkMobileCode(value);
	}

}
