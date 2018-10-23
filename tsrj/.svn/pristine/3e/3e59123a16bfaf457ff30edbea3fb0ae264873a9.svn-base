package org.tsrj.common.generator.plugins;

import org.mybatis.generator.api.GeneratedXmlFile;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;

import java.lang.reflect.Field;
import java.util.List;

/**
 * @author zhongqionghua
 * @create 2018年02月03日上午1:36:53
 */
public class BasePlugin extends PluginAdapter {

	@Override
	public boolean validate(List<String> warnings) {
		return Boolean.TRUE;
	}

	@Override
	public boolean sqlMapGenerated(GeneratedXmlFile sqlMap, IntrospectedTable introspectedTable) {
		try {
			Field field = sqlMap.getClass().getDeclaredField("isMergeable");
			field.setAccessible(true);
			field.set(sqlMap, Boolean.FALSE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Boolean.TRUE;
	}

	@Override
	public void initialized(IntrospectedTable introspectedTable) {
		introspectedTable.getFullyQualifiedTable();
		introspectedTable.getTableConfigurationProperty("pkg");
		// introspectedTable.setMyBatis3JavaMapperType(newName);
	}

}
