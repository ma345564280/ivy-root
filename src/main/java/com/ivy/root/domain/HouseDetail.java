package com.ivy.root.domain;

import java.util.Date;

public class HouseDetail {
    private Long id;

    private String houseAddress;

    private String houseArea;

    private Integer numberBedroom;

    private Integer numberLivingRoom;

    private Integer numberBathroom;

    private Integer numberKitchen;

    private Integer numberBalcony;

    private Date createTime;

    private Date updateTime;

    private Byte delFlag;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHouseAddress() {
        return houseAddress;
    }

    public void setHouseAddress(String houseAddress) {
        this.houseAddress = houseAddress == null ? null : houseAddress.trim();
    }

    public String getHouseArea() {
        return houseArea;
    }

    public void setHouseArea(String houseArea) {
        this.houseArea = houseArea == null ? null : houseArea.trim();
    }

    public Integer getNumberBedroom() {
        return numberBedroom;
    }

    public void setNumberBedroom(Integer numberBedroom) {
        this.numberBedroom = numberBedroom;
    }

    public Integer getNumberLivingRoom() {
        return numberLivingRoom;
    }

    public void setNumberLivingRoom(Integer numberLivingRoom) {
        this.numberLivingRoom = numberLivingRoom;
    }

    public Integer getNumberBathroom() {
        return numberBathroom;
    }

    public void setNumberBathroom(Integer numberBathroom) {
        this.numberBathroom = numberBathroom;
    }

    public Integer getNumberKitchen() {
        return numberKitchen;
    }

    public void setNumberKitchen(Integer numberKitchen) {
        this.numberKitchen = numberKitchen;
    }

    public Integer getNumberBalcony() {
        return numberBalcony;
    }

    public void setNumberBalcony(Integer numberBalcony) {
        this.numberBalcony = numberBalcony;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Byte getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Byte delFlag) {
        this.delFlag = delFlag;
    }
}