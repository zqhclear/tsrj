package org.tsrj.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by zhognqionghua on 2017/12/26.
 * 防止表单重复提交接口使用 调用业务接口前request token化写入redis
 * 检查缓存中的token 与 request带来的token进行比较 如果不一致就踢出此次请求
 * 如果三个积压的请求同时进来 也只有一个可以成功
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface TokenizeRequestCheckAnnotation {
}
