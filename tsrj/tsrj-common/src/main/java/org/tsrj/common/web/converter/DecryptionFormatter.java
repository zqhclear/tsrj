package org.tsrj.common.web.converter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;
import org.tsrj.common.encrypt.DESUtil;

/**
 * 解密
 * @author xiaohaizi
 * @date 2017年3月9日 上午11:23:06   
 *
 */
public class DecryptionFormatter implements Formatter<String> {

	@Override
	public String parse(String text, Locale locale) throws ParseException {
		return DESUtil.decryptAftorURLDecoder(text);

	}

	@Override
	public String print(String object, Locale locale) {
		return DESUtil.decryptAftorURLDecoder(object);
	}
}
