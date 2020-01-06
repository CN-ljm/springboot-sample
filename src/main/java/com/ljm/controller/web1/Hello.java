package com.ljm.controller.web1;

import com.ljm.service.impl.RegistryCityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
    public RegistryCityService cityService;

    @ApiOperation("测试swagger")
    @GetMapping("/sayHello")
    public String sayHello(){
        cityService.selectRegistryCityInfo();
        return "hello!";
    }

}
