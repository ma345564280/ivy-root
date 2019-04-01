package com.ivy.root.common.request;

import com.ivy.root.dto.PictureDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
* @Description:    作品保存请求参数
* @Author:         matao
* @CreateDate:     2019/2/26 14:31

* @UpdateUser:     matao
* @UpdateDate:     2019/2/26 14:31
* @UpdateRemark:   修改内容

* @Version:        1.0
*/

@Getter
@Setter
@ApiModel(description = "作品保存请求参数")
public class SaveDesignRequest extends BaseRequest {
    @ApiModelProperty(value = "作品简介")
    private String brief;
    @ApiModelProperty(value = "地址")
    private List<String> residence;
    @ApiModelProperty(value = "作品类型", required = true)
    private Byte type;
    @ApiModelProperty(value = "收费范围下限", required = true)
    private Integer miniCharge;
    @ApiModelProperty(value = "收费范围上限", required = true)
    private Integer maxCharge;
    @ApiModelProperty(value = "是否面议", required = true)
    private boolean isNegotiable;
    @ApiModelProperty(value = "设计类型", required = true)
    private String designStyle;
    @ApiModelProperty(value = "封面图片列表", required = true)
    private List<PictureDto>  coverPictureUrl;
    @ApiModelProperty(value = "作品图片列表", required = true)
    private List<PictureDto> normalPictureUrls;
    @ApiModelProperty(value = "设计师id", required = true)
    private Long designerId;
    @ApiModelProperty(value = "作品名", required = true)
    private String name;

}
