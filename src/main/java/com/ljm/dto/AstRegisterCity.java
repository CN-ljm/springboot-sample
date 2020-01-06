package com.ljm.dto;

import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class AstRegisterCity extends BaseModel {

    private static final long serialVersionUID = 945043344258768330L;

    @TableId
    @ApiModelProperty(value = "中登城市代码")
    private String cityCode;

    @ApiModelProperty(value = "中登城市")
    private String regCity;

    @ApiModelProperty(value = "中登城市英文名")
    private String regCityEn;

    @ApiModelProperty(value = "省份code")
    private String provinceCode;

    @ApiModelProperty(value = "登记省份")
    private String regProvince;

    @ApiModelProperty(value = "登记省份英文名")
    private String regProvinceEn;

}
