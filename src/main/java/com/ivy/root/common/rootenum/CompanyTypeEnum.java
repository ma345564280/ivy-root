package com.ivy.root.common.rootenum;
/**
 * @author gaoxin
 *
 */
public enum CompanyTypeEnum {

    DESIGN_COMPANY(1, "设计公司"),
    DECORATE_COMPANY(2, "装修公司"),
    DESIGN_STUDIO(2, "设计工作室"),
    DRAWING_COMPANY(2, "效果图公司"),

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
                if (element.getCode() == code) {
                    return element;
                }
            }
        }
        return null;
    }

    public static String getDescription(Integer code) {
        if (code != null) {
            for (CompanyTypeEnum element : values()) {
                if (element.getCode() == code) {
                    return element.getDescription();
                }
            }
        }
        return null;
    }


}
