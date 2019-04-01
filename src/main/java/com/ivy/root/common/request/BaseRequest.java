package com.ivy.root.common.request;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
* @Description:    基础请求参数类
* @Author:         matao
* @CreateDate:     2019/2/25 15:34

* @UpdateUser:     matao
* @UpdateDate:     2019/2/25 15:34
* @UpdateRemark:   修改内容

* @Version:        1.0
*/

@Getter
@Setter
@ApiModel(description = "基础请求参数类")
public class BaseRequest {

    @ApiModelProperty(value = "校验码")
    private String token;

}
