package com.ivy.root.common.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
* @Description:    分页请求类
* @Author:         matao
* @CreateDate:     2019/2/25 16:40

* @UpdateUser:     matao
* @UpdateDate:     2019/2/25 16:40
* @UpdateRemark:   修改内容

* @Version:        1.0
*/

@Getter
@Setter
@ApiModel(description = "分页请求类")
public class PageRequest extends BaseRequest {
    @ApiModelProperty(value = "每页大小")
    public Integer pageSize;
    @ApiModelProperty(value = "第几页")
    public Integer pageNo;
}
