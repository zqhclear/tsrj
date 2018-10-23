package org.tsrj.common.web.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 * Created by zhognqionghua on 2017/6/14.
 *
 * @author zhongqionghua
 * @date 2018/02/14
 */
public class DateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String source) {
        String pattern;
        if(source.length() == 7){
            pattern = "yyyy-MM";
        }else if(source.length() == 10){
            pattern = "yyyy-MM-dd";
        }else{
            pattern = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        try {
            return format.parse(source);
        } catch (ParseException e) {
            return null;
        }
    }
}