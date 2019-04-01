package com.ivy.root.common.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;


/**
* @Description:    注册请求参数
* @Author:         matao
* @CreateDate:     2019/2/25 16:42

* @UpdateUser:     matao
* @UpdateDate:     2019/2/25 16:42
* @UpdateRemark:   修改内容

* @Version:        1.0
*/
@Getter
@Setter
@ApiModel(description = "注册请求参数")
public class RegisterRequest {
    @ApiModelProperty(value = "用户名")
    private String userName;
    @ApiModelProperty(value = "手机号码")
    private String mobile;
    @ApiModelProperty(value = "性别")
    private Integer gender;
    @ApiModelProperty(value = "角色")
    private Integer role;
    @ApiModelProperty(value = "手机验证码")
    private Integer verification;
    @ApiModelProperty(value = "密码")
    private String password;
    @ApiModelProperty(value = "电子邮箱")
    private String email;

}
