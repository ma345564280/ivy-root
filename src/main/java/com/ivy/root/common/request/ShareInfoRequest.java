package com.ivy.root.common.request;

import com.ivy.root.dto.PictureDto;
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
    private List<PictureDto> sharePageBackground;
    private List<PictureDto> enterpriseImgs;
    private String companyName;
    private String introduction;
    private String companyType;
    private String phoneNumber;
    private List<String> serviceType;

}
