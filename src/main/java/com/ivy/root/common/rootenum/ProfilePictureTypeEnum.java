package com.ivy.root.common.rootenum;


/**
* @Description:    设计师主页上传照片类型
* @Author:         matao
* @CreateDate:     2019/3/11 14:11

* @UpdateUser:     matao
* @UpdateDate:     2019/3/11 14:11
* @UpdateRemark:   修改内容

* @Version:        1.0
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
                if (element.getCode().equals(code)) {
                    return element;
                }
            }
        }
        return null;
    }

    public static String getDescription(Byte code) {
        if (code != null) {
            for (ProfilePictureTypeEnum element : values()) {
                if (element.getCode().equals(code)) {
                    return element.getDescription();
                }
            }
        }
        return null;
    }


}
