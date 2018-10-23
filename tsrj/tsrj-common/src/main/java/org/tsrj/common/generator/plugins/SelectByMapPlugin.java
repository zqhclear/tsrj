package org.tsrj.common.generator.plugins;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.*;

import java.util.List;

/**
 * 根据map信息构造查询参数
 * Created with IntelliJ IDEA.
 * User: zhogniqonghua
 * Date: 18/02/08
 * Time: 上午11:24
 */
public class SelectByMapPlugin extends PluginAdapter {

    @Override
    public boolean validate(List<String> warnings) {
        return Boolean.TRUE;
    }


    @Override
    public boolean modelExampleClassGenerated(TopLevelClass topLevelClass,
                                              IntrospectedTable introspectedTable) {
        topLevelClass.addImportedType("java.util.Map");

        for (InnerClass innerClass : topLevelClass.getInnerClasses()) {
            if ("Criteria".equals(innerClass.getType().getShortName())) {
                Method method = new Method();
                method.setVisibility(JavaVisibility.PUBLIC);
                method.setReturnType(FullyQualifiedJavaType.getCriteriaInstance());
                method.setName("addByMap");

                FullyQualifiedJavaType newMapInstance = FullyQualifiedJavaType
                        .getNewMapInstance();
                newMapInstance.addTypeArgument(FullyQualifiedJavaType.getStringInstance());
                newMapInstance.addTypeArgument(FullyQualifiedJavaType.getObjectInstance());

                method.addParameter(new Parameter(newMapInstance, "map"));

                method.addBodyLine(" for (Map.Entry<String, Object> entry : map.entrySet()) {\n" +
                        "                if(entry.getValue().toString().startsWith(\"%\")){\n"+
                        "                    addCriterion(entry.getKey()+\" like\",entry.getValue(),null);\n"+
                        "                }else{\n" +
                        "                    addCriterion(entry.getKey()+\" =\",entry.getValue(),null);\n"+
                        "                }\n"+
                        "            }\n" +
                        "            return this;");

                innerClass.addMethod(method);
            }
        }
        return true;
    }
}
