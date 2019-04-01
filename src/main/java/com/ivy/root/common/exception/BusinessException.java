package com.ivy.root.common.exception;

import com.ivy.root.common.rootenum.ResponseCodeEnum;


/**
* @Description:    业务异常告警类
* @Author:         matao
* @CreateDate:     2019/2/25 15:34

* @UpdateUser:     matao
* @UpdateDate:     2019/2/25 15:34
* @UpdateRemark:   修改内容

* @Version:        1.0
*/
public class BusinessException extends RuntimeException {
    private Integer code;
    private String message;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public BusinessException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public BusinessException(ResponseCodeEnum errorEnum) {
        this.code = errorEnum.getCode();
        this.message = errorEnum.getDescription();


    }

}
