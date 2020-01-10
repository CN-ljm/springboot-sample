package com.ljm.config.spring.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 自己写一个bean工具
 */
@Component("springBeanUtil")
public class SpringBeanUtil implements ApplicationContextAware {

    private static ApplicationContext appContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("SpringBeanUtil");
        appContext = applicationContext;
    }

    /**
     * 获取spring正在运行的容器
     * @return
     */
    public static ApplicationContext getAppContext(){
        return appContext;
    }

    /**
     * 获取bean实例
     * @param beanName
     * @return
     */
    public static Object getBeanByName(String beanName){
        return appContext.getBean(beanName);
    }

    /**
     * 通过bean类型获取bean(泛型方法)
     *
     * @param requiredType
     * @param <T>
     * @return
     */
    public static <T> T getBeanByType(Class<T> requiredType){
        return appContext.getBean(requiredType);
    }

}
