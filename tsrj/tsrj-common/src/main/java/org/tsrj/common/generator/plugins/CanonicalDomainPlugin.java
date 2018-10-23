
package org.tsrj.common.generator.plugins;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.api.dom.xml.XmlElement;

import java.util.Arrays;
import java.util.List;

/**
 * @author zhongqionghua
 * @create 2018年02月08日下午7:35:35
 */
public class CanonicalDomainPlugin extends BasePlugin {
	private final static String SUPER_ClASS_FULL_TYPE = "BaseDomain<%s>";

	private final static List<String> SUPPORT_TRANSFER_TYPE = Arrays.asList("integer", "long", "string");

	@Override
	public boolean sqlMapInsertElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
		// String textContent;
		// XmlElement answer = new XmlElement("insertBatch");
		// for(Attribute attr:element.getAttributes()){
		// answer.addAttribute(attr);
		// }
		// for(Element sub:element.getElements()){
		// TextElement subText = (TextElement) sub;
		// textContent = subText.getContent();
		// if(){
		//
		// }
		// element.addElement(0, subText);
		// }
		return Boolean.TRUE;
	}

	@Override
	public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
		IntrospectedColumn idColumn = introspectedTable.getColumn("id");
		if (idColumn == null) {
			return Boolean.TRUE;
		}
		String idType = idColumn.getFullyQualifiedJavaType().getShortName().toLowerCase();
		if (SUPPORT_TRANSFER_TYPE.contains(idType)) {
			idType = idType.substring(0, 1).toUpperCase() + idType.substring(1);
			FullyQualifiedJavaType superClass = new FullyQualifiedJavaType(String.format(SUPER_ClASS_FULL_TYPE, idType));
			topLevelClass.setSuperClass(superClass);
			topLevelClass.addImportedType("org.tsrj.common.domain.BaseDomain");
		}
		
//		if(introspectedTable.getColumn("updated_at") == null) {
//			Method method = new Method();
//			method.setVisibility(JavaVisibility.PUBLIC);
//			method.setName("setUpdatedAt");
//			method.addParameter(new Parameter(FullyQualifiedJavaType.getDateInstance(), "updatedAt"));
//			method.addBodyLine("");
//			topLevelClass.addMethod(method);
//		}
		return Boolean.TRUE;
	}
}
