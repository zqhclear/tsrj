package org.tsrj.common.generator.plugins;

import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.Document;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;

/**
 * @author zhongqionghua
 * @create 2018年02月09日下午4:00:40
 */
public class MysqlPaginationPlugin extends BasePlugin {

	private static final String FULL_PAGE_TYPE = "org.tsrj.common.page.Page";

	private static final String PAGINATION_ID = "paginationSql";

	@Override
	public boolean modelExampleClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
		CommentGenerator commentGenerator = context.getCommentGenerator();
		FullyQualifiedJavaType pageType = new FullyQualifiedJavaType(FULL_PAGE_TYPE);
		topLevelClass.addImportedType(pageType);
		// 添加page字段
		Field page = new Field();
		page.setVisibility(JavaVisibility.PRIVATE);
		page.setType(pageType);
		page.setName("page");
		commentGenerator.addFieldComment(page, introspectedTable);
		topLevelClass.addField(page);

		Method method = new Method();
		method.setVisibility(JavaVisibility.PUBLIC);
		method.setName("setPage");
		method.addParameter(new Parameter(pageType, "page"));
		method.addBodyLine("this.page = page;");
		commentGenerator.addGeneralMethodComment(method, introspectedTable);
		topLevelClass.addMethod(method);

		method = new Method();
		method.setVisibility(JavaVisibility.PUBLIC);
		method.setName("getPage");
		method.setReturnType(pageType);
		method.addBodyLine("return this.page;");
		commentGenerator.addGeneralMethodComment(method, introspectedTable);
		topLevelClass.addMethod(method);
		return Boolean.TRUE;
	}

	@Override
	public boolean sqlMapDocumentGenerated(Document document, IntrospectedTable introspectedTable) {
		XmlElement answer = new XmlElement("sql");
		answer.addAttribute(new Attribute("id", PAGINATION_ID));
		XmlElement isNotNullElement = new XmlElement("if");
		isNotNullElement.addAttribute(new Attribute("test", "page != null"));
		isNotNullElement.addElement(new TextElement(
				"limit  #{page.startIndex,jdbcType=INTEGER},#{page.endIndex,jdbcType=INTEGER}"));
		answer.addElement(isNotNullElement);
		document.getRootElement().addElement(answer);
		return Boolean.TRUE;
	}

	@Override
	public boolean sqlMapSelectByExampleWithoutBLOBsElementGenerated(XmlElement element,
			IntrospectedTable introspectedTable) {
		addIncludeElement(element);
		return Boolean.TRUE;
	}

	@Override
	public boolean sqlMapSelectByExampleWithBLOBsElementGenerated(XmlElement element,
			IntrospectedTable introspectedTable) {
		addIncludeElement(element);
		return Boolean.TRUE;
	}

	/**
	 * @param element
	 */
	private void addIncludeElement(XmlElement element) {
		XmlElement includeElement = new XmlElement("include");
		includeElement.addAttribute(new Attribute("refid", PAGINATION_ID));
		element.addElement(includeElement);
	}
}
