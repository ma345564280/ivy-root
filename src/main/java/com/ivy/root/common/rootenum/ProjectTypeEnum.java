package com.ivy.root.common.rootenum;
/**
 * @author gaoxin
 *
 */
public enum ProjectTypeEnum {

    MODEL_ROOM(1, "样板间"),
    HOUSE(2, "家居别墅"),
    DINNER(3, "酒店餐饮"),
    GUEST_HOUSE(4, "民宿"),
    OTHERS(5, "其他"),

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

    ProjectTypeEnum(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    public static ProjectTypeEnum getStatus(Integer code) {
        if (code != null) {
            for (ProjectTypeEnum element : ProjectTypeEnum.values()) {
                if (element.getCode().equals(code)) {
                    return element;
                }
            }
        }
        return null;
    }

    public static String getDescription(Integer code) {
        if (code != null) {
            for (ProjectTypeEnum element : values()) {
                if (element.getCode().equals(code)) {
                    return element.getDescription();
                }
            }
        }
        return null;
    }


}
