package com.ivy.root.common.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;


/**
* @Description:   作品预约表查询请求参数
* @Author:         matao
* @CreateDate:     2019/2/25 11:25

* @UpdateUser:     matao
* @UpdateDate:     2019/2/25 11:25
* @UpdateRemark:   修改内容

* @Version:        1.0
*/
@Getter
@Setter
@ApiModel(description = "预约列表查询入参")
public class AppointmentRequest extends PageRequest {
    @ApiModelProperty(value = "设计师id")
    private Long designerId;
    @ApiModelProperty(value = "是否包含已删除")
    private Integer delFlag;

}
