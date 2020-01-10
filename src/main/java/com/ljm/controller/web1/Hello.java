package com.ljm.controller.web1;

import com.ljm.config.spring.lifecycle.SpringBeanUtil;
import com.ljm.service.PersonService;
import com.ljm.service.impl.RegistryCityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

/**
 * 视图控制器
 */
@Api("hello视图控制器")
@RestController
@RequestMapping("/hello")
public class Hello {

    @Autowired
    public PersonService personService;

    @ApiOperation("测试swagger")
    @GetMapping("/sayHello")
    public String sayHello(){

        personService.doSomething("sayHello");

        PersonService beanByType = SpringBeanUtil.getBeanByType(PersonService.class);
        if(beanByType == null){
            System.out.println("spring容器中不存在 PersonService 实例");
        }else {
            System.out.println("spring容器中存在 PersonService 实例");
        }

        return "hello!";
    }

}
