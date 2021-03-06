package com.ivy.root.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ivy.root.dto.PictureDto;

import java.util.Date;

public class DesignImg {
    private Long id;

    private Long designId;

    private String imgUrl;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    private Byte delFlag;

    private Byte imgType;

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Byte getImgType() {
        return imgType;
    }

    public void setImgType(Byte imgType) {
        this.imgType = imgType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDesignId() {
        return designId;
    }

    public void setDesignId(Long designId) {
        this.designId = designId;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Byte getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Byte delFlag) {
        this.delFlag = delFlag;
    }

    public DesignImg() {
    }

    public DesignImg(Long designId, PictureDto img, Byte imgType) {
        this.designId = designId;
        this.imgUrl = img.getFileUrl();
        this.description = img.getDescription();
        this.imgType = imgType;
        this.createTime = new Date();
    }
}