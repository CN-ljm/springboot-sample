package com.ljm.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ljm.dto.AstRegisterCity;
import com.ljm.mapper.RegistryCityMapper;
import com.ljm.utils.PinYinUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistryCityService {

    @Autowired
    private RegistryCityMapper registryCityMapper;


    public void selectRegistryCityInfo(){
        AstRegisterCity astRegisterCity = registryCityMapper.selectById("11XX00");
        System.out.println("输出父类一个属性：" + astRegisterCity.getLockVersion());
        System.out.println("原来的bean:" + astRegisterCity);
        /*Wrapper<AstRegisterCity> condition = new QueryWrapper<>();
        List<AstRegisterCity> Cities = registryCityMapper.selectList(condition);
        //处理一下数据
        //1.翻译城市
        Cities.stream().forEach(item-> {

            //2.翻译省份
            String provinceEn = null;
            String province = item.getRegProvince();
            if(province.contains("内蒙古自治区") ){
//                provinceEn = PinYinUtil.getPingYin(province);
                provinceEn = "Inner mongolia Autonomous Region";
            }
            if (province.contains("广西壮族自治区")){
                provinceEn = "Guangxi Zhuang Autonomous Region";
            }
            if (province.contains("西藏自治区")){
                provinceEn = "Xizang(Tibet) Autonomous Region";
            }
            if (province.contains("宁夏回族自治区")){
                provinceEn = "Ningxia Hui Autonomous Region";
            }
            if (province.contains("新疆维吾尔自治区")){
                provinceEn = "Xinjiang Uygur Autonomous Region";
            }

            item.setRegProvinceEn(provinceEn);
            //registryCityMapper.updateById(item);
        });*/

    }

}
