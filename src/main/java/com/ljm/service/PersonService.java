package com.ljm.service;

import com.ljm.config.annotation.Ant;

/**
 * 用来测试bean的生命周期
 */
@Ant("person")
public class PersonService {

    public void doSomething(String str){
        System.out.println(str);
    }

}
