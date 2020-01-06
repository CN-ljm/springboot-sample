package com.ljm;

import com.ljm.service.impl.RegistryCityService;
import com.ljm.utils.PinYinUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 应用启动类
 */
@SpringBootApplication
@MapperScan("com.ljm.mapper")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);

        String str = "";
        System.out.println(str.length());

        /*String src = "深圳市";
        if(src.contains("市")){
            src = src.substring(0,src.lastIndexOf("市"));
        }

        String en = PinYinUtil.getPingYin(src);
        System.out.println(en);*/

    }
}
