package com.ivy.root.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class User {
    private Long id;

    private Byte accountStatus;

    private String userName;

    private String password;

    private String mobile;

    private Integer gender;

    private String picUrl;

    private String type;

    private Integer role;

    private String address;

    private Byte delFlag;

    private Date createTime;

    private Date updateTime;

    private String openId;

    private String email;

    private String nickName;

    private String signature;

}