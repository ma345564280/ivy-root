package com.ivy.root.common.rootenum;


/**
* @Description:    响应返回值枚举
* @Author:         matao
* @CreateDate:     2019/3/11 14:12

* @UpdateUser:     matao
* @UpdateDate:     2019/3/11 14:12
* @UpdateRemark:   修改内容

* @Version:        1.0
*/
public enum ResponseCodeEnum {

    SUCCESS(200, "成功"),
    WRONG_ACCOUNT_INFO(301,"用户名或密码错误"),
    FAILED_SYSTEM(500, "系统错误"),
    NONE_PICTURE_RECEIVED(302, "请求参数中没有图片信息"),
    WRONG_OR_EMPTY_PARAM(303, "请求参数为空或者错误"),
    ILLEGAL_ACCOUNT(304, "非法用户"),

    ;

    private int code;

    private String description;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    ResponseCodeEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public static ResponseCodeEnum getStatus(Integer code) {
        if (code != null) {
            for (ResponseCodeEnum element : ResponseCodeEnum.values()) {
                if (element.getCode() == code) {
                    return element;
                }
            }
        }
        return null;
    }

    public static String getDescription(Integer code) {
        if (code != null) {
            for (ResponseCodeEnum element : values()) {
                if (element.getCode() == code) {
                    return element.getDescription();
                }
            }
        }
        return null;
    }


}
