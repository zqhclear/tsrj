/**
 * @author zhubingbing
 * @date   2017年3月29日 下午5:38:05   
 */  
package org.tsrj.common.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 校验地址
 * @author zhubingbing
 * @date   2017年3月29日 下午5:38:05   
 */
public class IsAddressValidator implements ConstraintValidator<IsAddress, String> {

	
	@Override
	public void initialize(IsAddress constraintAnnotation) {
		//初始化，得到注解数据
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		return ValidatorUtil.checkAddress(value);
	}

}
