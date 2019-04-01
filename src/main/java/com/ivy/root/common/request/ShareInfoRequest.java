package com.ivy.root.common.request;

import com.ivy.root.dto.PictureDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


/**
* @Description:    设计师个人主页（分享页）保存请求参数
* @Author:         matao
* @CreateDate:     2019/2/26 17:00

* @UpdateUser:     matao
* @UpdateDate:     2019/2/26 17:00
* @UpdateRemark:   修改内容

* @Version:        1.0
*/
@Getter
@Setter
@ApiModel(description = " 设计师个人主页（分享页）保存请求参数")
public class ShareInfoRequest {
    @ApiModelProperty(value = "设计师id", required = true)
    private Long userId;
    private List<String> skilledAt;
    private Integer miniCharge;
    private Integer maxCharge;
    private boolean isNegotiable;
    private List<String> address;
    private String achievement;
    private List<PictureDto> sharePageBackground;
    private List<PictureDto> enterpriseImgs;
    private String companyName;
    private String introduction;
    private String companyType;
    private String phoneNumber;
    private List<String> serviceType;

}
