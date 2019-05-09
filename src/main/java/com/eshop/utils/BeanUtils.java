package com.eshop.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BeanUtils {

    /**
     * 提取列表中对象的属性，返回对象属性的列表
     * @param beans
     * @param propertyName
     * @param <T>
     * @return
     */
    public static <T> List<T> extraProperty(List beans, String propertyName) {
        List<T> propertyList = new ArrayList<T>();
        for (Object bean : beans) {
            try {
                Field field =  bean.getClass().getDeclaredField(propertyName);
                field.setAccessible(true);
                propertyList.add((T)field.get(bean));
            } catch (Exception e) {
                // no operation
            }
        }
        return propertyList;
    }

    /**
     * 根据列表对象的属性构造属性到对象的映射
     * @param beans
     * @param propertyName
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K, V> Map<K, V> mapBy(List beans, String propertyName) {
        Map<K, V> mapBeans = new HashMap<K, V>();
        for (Object bean : beans) {
            try {
                Field field =  bean.getClass().getDeclaredField(propertyName);
                field.setAccessible(true);
                mapBeans.put((K)field.get(bean), (V)bean);
            } catch (Exception e) {
                // no operation
            }
        }
        return mapBeans;
    }
}
