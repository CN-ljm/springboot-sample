package com.ljm.config.annotation;

import java.lang.annotation.*;

/**
 * 自定义一个注解
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Ant {

    /**
     * 名字
     * @return
     */
    String value() default "";

}
