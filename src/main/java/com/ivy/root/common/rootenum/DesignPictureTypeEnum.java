package com.ivy.root.common.rootenum;


/**
* @Description:    上传照片类型枚举
* @Author:         matao
* @CreateDate:     2019/3/11 14:10

* @UpdateUser:     matao
* @UpdateDate:     2019/3/11 14:10
* @UpdateRemark:   修改内容

* @Version:        1.0
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
                if (element.getCode().equals(code)) {
                    return element;
                }
            }
        }
        return null;
    }

    public static String getDescription(Byte code) {
        if (code != null) {
            for (DesignPictureTypeEnum element : values()) {
                if (element.getCode().equals(code)) {
                    return element.getDescription();
                }
            }
        }
        return null;
    }


}
