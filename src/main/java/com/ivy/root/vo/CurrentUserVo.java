package com.ivy.root.vo;

import com.ivy.root.domain.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author matao
 */
@Getter
@Setter
@ApiModel(description = "用户信息表")
public class CurrentUserVo {
    @ApiModelProperty(value = "用户名")
    private String name;
    @ApiModelProperty(value = "用户头像")
    private String avatar;
    @ApiModelProperty(value = "用户id")
    private Long userid;
    @ApiModelProperty(value = "用户电子邮箱")
    private String email;
    @ApiModelProperty(value = "用户签名")
    private String signature;
    @ApiModelProperty(value = "用户头衔")
    private String title;
    @ApiModelProperty(value = "用户所在组")
    private String group;
    @ApiModelProperty(value = "用户标签")
    private List<String> tags;
    @ApiModelProperty(value = "用户通知数")
    private Integer notifyCount;
    @ApiModelProperty(value = "用户所在国家")
    private String country;
    @ApiModelProperty(value = "用户住址")
    private List<String> residence;
    @ApiModelProperty(value = "用户住址")
    private String address;
    @ApiModelProperty(value = "用户手机号")
    private String phone;

    public CurrentUserVo(User user) {

        this.name = user.getNickName() == null ? "" : user.getNickName();
        this.avatar = user.getPicUrl() == null ? "" : user.getPicUrl();

        this.userid = user.getId();
        this.email = user.getEmail() == null ? "" : user.getEmail();
        this.signature = user.getSignature() == null ? "" : user.getSignature();




    }
}
