package com.ljm.config.spring.lifecycle;

import com.ljm.config.annotation.Ant;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.stereotype.Component;

@Component
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        System.out.println("MyBeanDefinitionRegistryPostProcessor.postProcessBeanDefinitionRegistry");
        ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(registry, true);
        scanner.addIncludeFilter(new AnnotationTypeFilter(Ant.class));
        scanner.scan("com.ljm");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("MyBeanDefinitionRegistryPostProcessor.postProcessBeanFactory");
        String[] beanNames = beanFactory.getBeanNamesForAnnotation(Ant.class);
        System.out.println("拿到注解@Ant的bean name:" + beanNames.toString());
        for (String bn : beanNames){
            Object bean = beanFactory.getBean(bn);
            if (bean != null){
                System.out.printf("拿到名字为 %s 的bean实例 \n", bn);
            }else {
                System.out.printf("没有找到名字为 %s 的bean实例 \n", bn);
            }
        }
    }
}
