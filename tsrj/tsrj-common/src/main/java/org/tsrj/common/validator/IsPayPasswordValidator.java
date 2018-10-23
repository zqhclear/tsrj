/**
 * @author zhubingbing
 * @date   2017年3月29日 下午5:38:05   
 */  
package org.tsrj.common.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 校验支付密码
 * @author zhubingbing
 * @date   2017年3月29日 下午5:38:05   
 */
public class IsPayPasswordValidator implements ConstraintValidator<IsPayPassword, String> {

	
	@Override
	public void initialize(IsPayPassword constraintAnnotation) {
		//初始化，得到注解数据
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return ValidatorUtil.checkPayPassword(value);
	}

}
