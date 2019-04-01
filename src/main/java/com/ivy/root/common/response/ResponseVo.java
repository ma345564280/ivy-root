package com.ivy.root.common.response;


import com.ivy.root.common.rootenum.ResponseCodeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
* @Description:    通用响应类
* @Author:         matao
* @CreateDate:     2019/2/26 17:07

* @UpdateUser:     matao
* @UpdateDate:     2019/2/26 17:07
* @UpdateRemark:   修改内容

* @Version:        1.0
*/

@ApiModel(description = "通用响应类")
public class ResponseVo <T> extends BaseResponseVo{
    @ApiModelProperty(value = "返回的数据", required = true)
    private T data;
    @ApiModelProperty(value = "响应的结果描述", required = true)
    private String msg;
    @ApiModelProperty(value = "响应码", required = true)
    private Integer code;
    @ApiModelProperty(value = "响应状态", required = true)
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <T> ResponseVo<T> buildSuccessInstance(T data) {
        ResponseVo<T> responseVo = new ResponseVo<T>();
        responseVo.setData(data);
        responseVo.setCode(ResponseCodeEnum.SUCCESS.getCode());
        responseVo.setMsg(ResponseCodeEnum.SUCCESS.getDescription());
        responseVo.setStatus("ok");
        return responseVo;
    }

    public static <T> ResponseVo<T> buildFailInstance(String message, Integer code) {
        ResponseVo<T> responseVo = new ResponseVo();
        responseVo.setCode(code);
        responseVo.setMsg(message);
        responseVo.setStatus("failed");
        return responseVo;
    }
    public static <T> ResponseVo<T> buildFailInstance(ResponseCodeEnum responseCodeEnum) {
        ResponseVo<T> responseVo = new ResponseVo();
        responseVo.setCode(responseCodeEnum.getCode());
        responseVo.setMsg(responseCodeEnum.getDescription());
        responseVo.setStatus("failed");
        return responseVo;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
