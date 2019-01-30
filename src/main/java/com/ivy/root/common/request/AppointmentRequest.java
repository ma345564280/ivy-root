package com.ivy.root.common.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppointmentRequest extends PageRequest {
    private Long designerId;
    private Integer delFlag;

}
