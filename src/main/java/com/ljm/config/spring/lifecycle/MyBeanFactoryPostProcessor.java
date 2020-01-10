package com.ljm.config.spring.lifecycle;

import com.ljm.service.PersonService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * bean工厂后处理
 */
@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("MyBeanFactoryPostProcessor");
        PersonService bean = beanFactory.getBean(PersonService.class);
        if (bean != null){
            System.out.println("bean factory 能扫描到没有包含spring annotation的类");
        }else{
            System.out.println("bean factory 不能扫描到没有包含spring annotation的类");
        }
    }
}
