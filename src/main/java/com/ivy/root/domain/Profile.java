package com.ivy.root.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ivy.root.common.request.ShareInfoRequest;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Profile {
    private Long id;

    private Long userId;

    private String skilledIn;

    private Boolean negotiableCharge;

    private Integer minCharge;

    private Integer maxCharge;

    private String address;

    private String achievement;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    private String nickName;

    private String introduction;

    private String companyType;

    private String phoneNumber;

    private String serviceType;

    private Integer profileStatus;

    public Profile(ShareInfoRequest request) {
        this.profileStatus = 1;

        if (request.getAddress() != null && request.getAddress().size() > 0) {
            String addressStr = "";
            for (String address : request.getAddress()) {
                addressStr = addressStr + "，" + address;
            }
            this.address = addressStr.substring(1);
        }

        this.achievement = request.getAchievement();
        this.companyType = request.getCompanyType();
        this.maxCharge = request.getMaxCharge();
        this.minCharge = request.getMiniCharge();
        this.negotiableCharge = request.isNegotiable();
        this.introduction = request.getIntroduction();
        this.nickName = request.getCompanyName();
        this.phoneNumber = request.getPhoneNumber();

        if (request.getSkilledAt() != null && request.getSkilledAt().size() > 0) {
            String skills = "";
            for (String skill : request.getSkilledAt()) {
                skills = skills + "，" + skill;
            }
            this.skilledIn = skills.substring(1);
        }

        this.userId = request.getUserId();

        if (request.getServiceType() != null && request.getServiceType().size() > 0) {
            String serviceTypes = "";
            for (String type : request.getServiceType()) {
                serviceTypes = serviceTypes + "，" + type;
            }
            this.serviceType = serviceTypes.substring(1);
        }

        this.createTime = new Date();

    }

    public Profile() {
    }

}