package com.ivy.root.common.rootenum;
/**
* @Description:    预约状态枚举
* @Author:          matao
* @CreateDate:     2019/3/11 14:09

* @UpdateUser:     matao
* @UpdateDate:     2019/3/11 14:09
* @UpdateRemark:   修改内容

* @Version:        1.0
*/
public enum AppointmentStatusEnum {
    DESIGN_COMPANY(0, "客户预约"),
    DECORATE_COMPANY(1, "设计师接单"),
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

    AppointmentStatusEnum(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    public static AppointmentStatusEnum getStatus(Integer code) {
        if (code != null) {
            for (AppointmentStatusEnum element : AppointmentStatusEnum.values()) {
                if (element.getCode().equals(code)) {
                    return element;
                }
            }
        }
        return null;
    }

    public static String getDescription(Integer code) {
        if (code != null) {
            for (AppointmentStatusEnum element : values()) {
                if (element.getCode().equals(code)) {
                    return element.getDescription();
                }
            }
        }
        return null;
    }


}
