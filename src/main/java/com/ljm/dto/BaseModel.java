package com.ljm.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BaseModel implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 5461595535924882208L;

    @TableField(value = "enable")
    @ApiModelProperty(value = "是否启用", hidden = true)
    protected String enable;

    @TableField(value = "remark")
    @ApiModelProperty(value = "备注", hidden = true)
    protected String remark;

    @TableField(value = "create_by")
    @ApiModelProperty(value = "创建人id", hidden = true)
    protected Long createBy;

    @TableField(value = "create_time")
    @ApiModelProperty(value = "创建时间", hidden = true)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    protected Date createTime;

    @TableField(value = "update_by")
    @ApiModelProperty(value = "更新人id", hidden = true)
    protected Long updateBy;

    @TableField(value = "update_time")
    @ApiModelProperty(value = "更新时间", hidden = true)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    protected Date updateTime;

    @TableField(value = "lock_version")
    @ApiModelProperty(value = "乐观锁版本号", hidden = true)
    protected Long lockVersion;

    @TableField(value = "data_hash")
    @ApiModelProperty(value = "数据hash", hidden = true)
    protected String dataHash;

    public BaseModel() {
        // TODO Auto-generated constructor stub
    }

}
