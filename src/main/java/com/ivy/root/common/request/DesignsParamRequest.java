package com.ivy.root.common.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
* @Description:   设计师作品列表请求页
* @Author:         matao
* @CreateDate:     2019/2/25 16:25

* @UpdateUser:     matao
* @UpdateDate:     2019/2/25 16:25
* @UpdateRemark:   修改内容:新增

* @Version:        1.0
*/

@ApiModel(description = "设计师作品列表请求页")
@Getter
@Setter
public class DesignsParamRequest extends PageRequest {

    @ApiModelProperty(value = "设计师id")
    public Long designerId;

}
