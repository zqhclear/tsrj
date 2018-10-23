/**
 * @author zhubingbing
 * @date   2017年3月29日 下午5:38:05   
 */  
package org.tsrj.common.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 校验登录密码
 * @author zhubingbing
 * @date   2017年3月29日 下午5:38:05   
 */
public class IsLoginPasswordValidator implements ConstraintValidator<IsLoginPassword, String> {

	
	@Override
	public void initialize(IsLoginPassword constraintAnnotation) {
		//初始化，得到注解数据
	} 

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return ValidatorUtil.checkLoginPassword(value);
	}

}
