package com.ivy.root.common.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ShareInfoRequest {
    private Long userId;
    private List<String> skilledAt;
    private Integer miniCharge;
    private Integer maxCharge;
    private boolean isNegotiable;
    private List<String> address;
    private String achievement;
    private List<String> sharePageBackground;
    private List<String> enterpriseImgs;
    private String companyName;
    private String introduction;
    private String companyType;
    private String phoneNumber;
    private List<String> serviceType;

}
