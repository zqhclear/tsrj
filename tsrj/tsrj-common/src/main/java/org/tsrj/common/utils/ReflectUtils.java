package org.tsrj.common.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hqm
 * @Description: 反射工具类
 * @date Nov 5, 2014 3:36:32 PM
 */
public class ReflectUtils {

    /**
     * 利用反射获取指定对象的指定属性
     *
     * @param obj       目标对象
     * @param fieldName 目标属性
     * @return 目标属性的值
     */
    public static Object getFieldValue(Object obj, String fieldName) {
        Object result = null;
        Field field = ReflectUtils.getField(obj, fieldName);
        if (field != null) {
            field.setAccessible(true);
            try {
                result = field.get(obj);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 利用反射获取指定对象里面的指定属性
     *
     * @param obj       目标对象
     * @param fieldName 目标属性
     * @return 目标字段
     */
    private static Field getField(Object obj, String fieldName) {
        Field field = null;
        for (Class<?> clazz = obj.getClass(); clazz != Object.class; clazz = clazz.getSuperclass()) {
            try {
                field = clazz.getDeclaredField(fieldName);
                break;
            } catch (NoSuchFieldException e) {
            }
        }
        return field;
    }

    /**
     * 利用反射设置指定对象的指定属性为指定的值
     *
     * @param obj        目标对象
     * @param fieldName  目标属性
     * @param fieldValue 目标值
     */
    public static void setFieldValue(Object obj, String fieldName, String fieldValue) {
        Field field = ReflectUtils.getField(obj, fieldName);
        if (field != null) {
            try {
                field.setAccessible(true);
                field.set(obj, fieldValue);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    /***
     * 利用反射设置获取对象的属性名和对应的值
     *
     * @param obj
     * @throws Exception
     */
    public static Map<String, Object> getClassInfo(Object obj) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Class<?> clas = obj.getClass();
            Field[] fields = clas.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                if (field.getType().getName().equals("java.lang.String")) {
                    if (StringUtils.isNotEmpty((String) field.get(obj)))
                        map.put(field.getName(), field.get(obj));
                } else {
                    if (field.get(obj) != null && !field.getName().equals("serialVersionUID")) {
                        map.put(field.getName(), field.get(obj));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return map;


    }

    /***
     * 利用反射设置获取对象的属性名和对应的值
     * 并且键为下划线写法
     *
     * @param obj
     * @throws Exception
     */
    public static Map<String, Object> getObjectFiledInfo(Object obj) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Class<?> clas = obj.getClass();
            Field[] fields = clas.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                if (field.get(obj) != null && !field.getName().equals("serialVersionUID")) {
                    map.put(StringUtils.camelToUnderline(field.getName()), field.get(obj));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }


    /**
     * 解析Conditions
     *
     * @param obj
     * @return
     */
    public static List<Map<String, Object>> resolveConditons(Object obj) {
        List<Map<String, Object>> result = new ArrayList<>();
        try {
            Class<?> clas = obj.getClass();
            Field oredCriteriaFileld = clas.getDeclaredField("oredCriteria");
            oredCriteriaFileld.setAccessible(true);
            List oredCriteria = (List) oredCriteriaFileld.get(obj);
            if (CollectionUtils.isNotEmpty(oredCriteria)) {
                Object criteria = oredCriteria.get(0);
                Class<?> aClass = criteria.getClass();
                Field criteria1 = aClass.getSuperclass().getDeclaredField("criteria");
                criteria1.setAccessible(true);
                List list = (List) criteria1.get(criteria);
                if (CollectionUtils.isNotEmpty(list)) {
                    //解析参数
                    for (int i = 0; i < list.size(); i++) {
                        Object criterion = list.get(0);
                        Class<?> aClass1 = criterion.getClass();
                        Field condition = aClass1.getDeclaredField("condition");
                        Field value = aClass1.getDeclaredField("value");
                        condition.setAccessible(true);
                        value.setAccessible(true);

                        String o = condition.get(criterion).toString();
                        Object o1 = value.get(criterion);
                        Map<String, Object> map = new HashMap<>();
                        map.put("condition", o.replaceAll("(\\s)+", " ") + " ");
                        map.put("value", o1);

                        result.add(map);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

}
