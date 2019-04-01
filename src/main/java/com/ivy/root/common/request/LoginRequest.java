package com.ivy.root.common.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
* @Description:    登陆请求参数
* @Author:         matao
* @CreateDate:     2019/2/25 16:30

* @UpdateUser:     matao
* @UpdateDate:     2019/2/25 16:30
* @UpdateRemark:   修改内容

* @Version:        1.0
*/
@Getter
@Setter
@ApiModel(description = "登陆请求参数")
public class LoginRequest {

    @ApiModelProperty(value = "登陆用户名")
    private String userName;
    @ApiModelProperty(value = "登陆密码")
    private String password;

    @ApiModelProperty(value = "登陆手机号")
    private String mobile;
    @ApiModelProperty(value = "手机验证码")
    private String verificationCode;
}
