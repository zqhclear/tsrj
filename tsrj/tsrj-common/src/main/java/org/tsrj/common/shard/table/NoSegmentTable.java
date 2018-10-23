package org.tsrj.common.shard.table;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 作为标记，表示不要使用分表注解
 *
 * @Author penglai
 * @Date 2016/11/28.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface NoSegmentTable {
}
