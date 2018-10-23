package org.tsrj.common.utils;


import java.util.Map;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import net.sf.json.xml.XMLSerializer;

/**
 * Created by hqm on 2018/1/10.
 */
public class XmlUtil {

    public static String object2xml(Object object,String name){
        XStream xstream = new XStream(new DomDriver());
        xstream.alias(name, object.getClass());
        return xstream.toXML(object);
    }

    /**
     * xml转为json字符串
     * @param xml
     * @return
     */
    public static String convertXml2Json(String xml){
        XMLSerializer xmlSerializer = new XMLSerializer();
        return xmlSerializer.read(xml).toString();
    }

    public static Object xml2object(String xml,String name,Class<?> className){
        XStream xstream = new XStream(new DomDriver());
        xstream.alias(name, className);
        return xstream.fromXML(preDoXml(xml));
    }

    /**
     *解析xml成javabean(list)
     * @param xml 需解析的xml字符
     * @param map key:xml节点标签  ,value:xmljavabean类
     * @param key javabean类里面的list名字
     * @return
     */
    public static Object xml2List(String xml,Map<String,Class<?>> map/*,String key*/){
    	xml="<?xml version=\"1.0\" encoding=\"UTF-8\"?>"+preDoXml(xml);
    	XStream xstream = new XStream(new DomDriver());
        for(Map.Entry<String, Class<?>> entry:map.entrySet()){
            xstream.alias(entry.getKey(), entry.getValue());
        }
       // xstream.addImplicitCollection(map.get(key),key);
        return xstream.fromXML(xml);
    }

    private static String preDoXml(String xml){
     return   xml.substring(xml.indexOf("<plain>"), xml.indexOf("<signature>"));
    }
}
