package com.ivy.root.common.rootenum;
/**
 * @author gaoxin
 *
 */
public enum DesignPictureTypeEnum {

    COVER_PICTURE(new Byte("1"), "作品封面"),
    NORMAL_PICTURE(new Byte("2"),"内容图片"),

    ;

    private Byte code;

    private String description;

    public Byte getCode() {
        return code;
    }

    public void setCode(byte code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    DesignPictureTypeEnum(Byte code, String description) {
        this.code = code;
        this.description = description;
    }

    public static DesignPictureTypeEnum getStatus(Byte code) {
        if (code != null) {
            for (DesignPictureTypeEnum element : DesignPictureTypeEnum.values()) {
                if (element.getCode() == code) {
                    return element;
                }
            }
        }
        return null;
    }

    public static String getDescription(Byte code) {
        if (code != null) {
            for (DesignPictureTypeEnum element : values()) {
                if (element.getCode() == code) {
                    return element.getDescription();
                }
            }
        }
        return null;
    }


}
