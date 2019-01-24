package com.ivy.root.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Appointment {
    private Long id;

    private Long designerId;

    private String customerName;

    private String customerPhoneNumber;

    private Date createTime;

    private Byte status;

    private Byte delFlag;

    private Date delTime;

    private String note;

    private String projectType;

    private String address;

}