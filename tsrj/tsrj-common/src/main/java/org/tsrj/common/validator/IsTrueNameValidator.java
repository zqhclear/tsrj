/**
 * @author zhubingbing
 * @date   2017年3月29日 下午5:38:05   
 */  
package org.tsrj.common.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 校验真实名称
 * @author zhubingbing
 * @date   2017年3月29日 下午5:38:05   
 */
public class IsTrueNameValidator implements ConstraintValidator<IsTrueName, String> {

	
	@Override
	public void initialize(IsTrueName constraintAnnotation) {
		//初始化，得到注解数据
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return ValidatorUtil.checkTrueName(value);

	}

}
