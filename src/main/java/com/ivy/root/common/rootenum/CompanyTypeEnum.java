package com.ivy.root.common.rootenum;


/**
* @Description:    公司类型枚举
* @Author:         matao
* @CreateDate:     2019/3/11 14:10

* @UpdateUser:     matao
* @UpdateDate:     2019/3/11 14:10
* @UpdateRemark:   修改内容

* @Version:        1.0
*/
public enum CompanyTypeEnum {

    DESIGN_COMPANY(1, "设计公司"),
    DECORATE_COMPANY(2, "装修公司"),
    DESIGN_STUDIO(3, "设计工作室"),
    DRAWING_COMPANY(4, "效果图公司"),

    ;

    private Integer code;

    private String description;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    CompanyTypeEnum(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    public static CompanyTypeEnum getStatus(Integer code) {
        if (code != null) {
            for (CompanyTypeEnum element : CompanyTypeEnum.values()) {
                if (element.getCode().equals(code)) {
                    return element;
                }
            }
        }
        return null;
    }

    public static String getDescription(Integer code) {
        if (code != null) {
            for (CompanyTypeEnum element : values()) {
                if (element.getCode().equals(code)) {
                    return element.getDescription();
                }
            }
        }
        return null;
    }


}
