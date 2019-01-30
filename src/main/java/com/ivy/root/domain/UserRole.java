package com.ivy.root.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UserRole {
    private Long id;

    private Long userId;

    private Long roleId;

    private Date createTime;

    private Byte delFlag;

    private Date delTime;

    public UserRole(Long userId, Long roleId) {
        this.userId = userId;
        this.roleId = roleId;
        this.createTime = new Date();
        this.delFlag = 0;

    }

}