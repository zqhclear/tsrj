package org.tsrj.common.generator.plugins;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.*;

import java.lang.reflect.Field;
import java.util.List;

import static org.mybatis.generator.internal.util.StringUtility.stringHasValue;

/**
 * @author zhongqionghua
 * @create 2018年02月08日下午7:51:51
 */
public class LikePlugin extends BasePlugin {
	
	@Override
    public boolean modelExampleClassGenerated(TopLevelClass topLevelClass,
            IntrospectedTable introspectedTable) {

        InnerClass criteria = null;
        // first, find the Criteria inner class
        for (InnerClass innerClass : topLevelClass.getInnerClasses()) {
        	if("Criterion".equals(innerClass.getType().getShortName())){
        		org.mybatis.generator.api.dom.java.Field field = new org.mybatis.generator.api.dom.java.Field();
        	    field.setName("isFullLike"); //$NON-NLS-1$
        	    field.setType(FullyQualifiedJavaType.getBooleanPrimitiveInstance());
        	    field.setVisibility(JavaVisibility.PRIVATE);
        	    innerClass.addField(field);
        	    Method method = new Method();
        	    method.addParameter(new Parameter(FullyQualifiedJavaType
                        .getStringInstance(), "isFullLike")); 
        	    method.setName("setIsFullLike");
                method.addBodyLine("this.isFullLike = isFullLike"); 
                innerClass.addMethod(method);
                method = new Method();
        	    method.addParameter(new Parameter(FullyQualifiedJavaType
                        .getStringInstance(), "isPreLike")); //$NON-NLS-1$
                method.addBodyLine("this.isPreLike = isPreLike"); //$NON-NLS-1$
                innerClass.addMethod(method);
                method = new Method();
                
        	    method.addParameter(new Parameter(FullyQualifiedJavaType
                        .getStringInstance(), "isSufLike")); //$NON-NLS-1$
                method.addBodyLine("this.isSufLike = isSufLike"); //$NON-NLS-1$
                innerClass.addMethod(method);
                
        	}else if ("GeneratedCriteria".equals(innerClass.getType().getShortName())) { //$NON-NLS-1$
                criteria = innerClass;
                break;
            }
        }

        if (criteria == null) {
            // can't find the inner class for some reason, bail out.
            return true;
        }
        List<Method> methods = null;
		try {
			Field field = InnerClass.class.getDeclaredField("methods");
			field.setAccessible(true);
	        methods = (List<Method>) field.get(criteria);
		} catch (Exception e) {
		} 
        for (IntrospectedColumn introspectedColumn : introspectedTable
                .getNonBLOBColumns()) {
            if (!introspectedColumn.isJdbcCharacterColumn()
                    || !introspectedColumn.isStringColumn()) {
                continue;
            }
            
           // criteria.addMethod(method);
        }

        return true;
    }
	
	private String getLikeMethodName(IntrospectedColumn introspectedColumn){
		StringBuilder sb = new StringBuilder();
        sb.append(introspectedColumn.getJavaProperty());
        sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
        sb.insert(0, "andLike"); 
        return sb.toString();
	}
	private Method getFullLikeMethod(IntrospectedColumn introspectedColumn,
            String nameFragment) {
        Method method = new Method();
        method.setVisibility(JavaVisibility.PUBLIC);
        method.addParameter(new Parameter(introspectedColumn
                .getFullyQualifiedJavaType(), "value")); 
        StringBuilder sb = new StringBuilder();
        method.setName(getLikeMethodName(introspectedColumn));
        method.setReturnType(FullyQualifiedJavaType.getCriteriaInstance());
       if (stringHasValue(introspectedColumn
                .getTypeHandler())) {
            sb.append("Criterion temp = new Criterion("); 
            sb.append("like");
            sb.append(",");
            sb.append("value,");
            sb.append(introspectedColumn.getTypeHandler());
            sb.append(");");
        } else {
        	sb.append("Criterion temp = new Criterion("); //$NON-NLS-1$
            sb.append("like");
            sb.append(",");
            sb.append("value);");
        }
       	sb.append("temp.setIsFullLike(true);");
        method.addBodyLine(sb.toString());
        return method;
    }
}
