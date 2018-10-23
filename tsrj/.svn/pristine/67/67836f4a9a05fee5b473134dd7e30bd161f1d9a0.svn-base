package org.tsrj.common.generator.plugins;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.*;

import java.util.List;

/**
 * 
 * @author zhognqionghua
 * 
 * @Description:自动生成domain对象构建器
 * 
 * @date Dec 31, 2014 3:28:40 PM
 * 
 */
public class BuildersPlugin extends PluginAdapter {

	@Override
	public boolean validate(List<String> warnings) {
		return Boolean.TRUE;
	}

	@Override
	public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
		generateBuilders(introspectedTable, topLevelClass);
		return Boolean.TRUE;
	}

	@Override
	public boolean modelRecordWithBLOBsClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
		generateBuilders(introspectedTable, topLevelClass);
		return Boolean.TRUE;
	}

	@Override
	public boolean modelPrimaryKeyClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
		generateBuilders(introspectedTable, topLevelClass);
		return Boolean.TRUE;
	}

	private void generateBuilders(IntrospectedTable introspectedTable, TopLevelClass topLevelClass) {
		List<IntrospectedColumn> columns;
		if (introspectedTable.getRules().generateRecordWithBLOBsClass()) {
			columns = introspectedTable.getNonBLOBColumns();
		} else {
			columns = introspectedTable.getAllColumns();
		}

		for (IntrospectedColumn column : columns) {
			Method method = new Method();
			method.setVisibility(JavaVisibility.PUBLIC);
			method.setReturnType(new FullyQualifiedJavaType(introspectedTable.getFullyQualifiedTable()
					.getDomainObjectName()));
			method.setName(column.getJavaProperty());
			method.addParameter(new Parameter(column.getFullyQualifiedJavaType(), "value"));
			method.addBodyLine("this." + column.getJavaProperty() + " = value;");
			method.addBodyLine("return this;");
			topLevelClass.addMethod(method);
		}
	}
}
