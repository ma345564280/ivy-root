package com.ivy.root.common.request;

import java.util.List;

public class SaveDesignRequest extends BaseRequest {
    private String brief;
    private List<String> residence;
    private Byte type;
    private String priceRange;
    private String designStyle;
    private List<String>  coverPictureUrl;
    private List<String> normalPictureUrls;
    private Long designerId;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public List<String> getResidence() {
        return residence;
    }

    public void setResidence(List<String> residence) {
        this.residence = residence;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public String getPriceRange() {
        return priceRange;
    }

    public void setPriceRange(String priceRange) {
        this.priceRange = priceRange;
    }

    public String getDesignStyle() {
        return designStyle;
    }

    public void setDesignStyle(String designStyle) {
        this.designStyle = designStyle;
    }

    public List<String>  getCoverPictureUrl() {
        return coverPictureUrl;
    }

    public void setCoverPictureUrl(List<String>  coverPictureUrl) {
        this.coverPictureUrl = coverPictureUrl;
    }

    public List<String> getNormalPictureUrls() {
        return normalPictureUrls;
    }

    public void setNormalPictureUrls(List<String> normalPictureUrls) {
        this.normalPictureUrls = normalPictureUrls;
    }

    public Long getDesignerId() {
        return designerId;
    }

    public void setDesignerId(Long designerId) {
        this.designerId = designerId;
    }
}
