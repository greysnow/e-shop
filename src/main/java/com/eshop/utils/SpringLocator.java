package com.eshop.utils;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * User: liang.liu
 * <p/>
 * Date: 15-7-27, Time: 下午8:21
 */
public class SpringLocator implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @SuppressWarnings("unchecked")
    public static <T> T getBean(String name) {
        return (T) applicationContext.getBean(name);
    }

    @SuppressWarnings("unchecked")
    public static <T> T getBean(Class<T> clazz) {
        return (T) BeanFactoryUtils.beanOfType(applicationContext, clazz);
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringLocator.applicationContext = applicationContext;
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

}
