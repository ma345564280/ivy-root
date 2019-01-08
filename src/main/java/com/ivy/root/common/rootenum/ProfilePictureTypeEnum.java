package com.ivy.root.common.rootenum;
/**
 * @author gaoxin
 *
 */
public enum ProfilePictureTypeEnum {

    COMPANY_SHARE_BACKGROUND_PICTURE(new Byte("1"), "公司分享页面背景图片"),
    COMPANY_PICTURE(new Byte("2"),"公司形象图片"),

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

    ProfilePictureTypeEnum(Byte code, String description) {
        this.code = code;
        this.description = description;
    }

    public static ProfilePictureTypeEnum getStatus(Byte code) {
        if (code != null) {
            for (ProfilePictureTypeEnum element : ProfilePictureTypeEnum.values()) {
                if (element.getCode() == code) {
                    return element;
                }
            }
        }
        return null;
    }

    public static String getDescription(Byte code) {
        if (code != null) {
            for (ProfilePictureTypeEnum element : values()) {
                if (element.getCode() == code) {
                    return element.getDescription();
                }
            }
        }
        return null;
    }


}
