package com.ivy.root.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ivy.root.common.request.SaveDesignRequest;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Design {
    private Long id;

    private Long designerId;

    private String name;

    private String brief;

    private Byte type;

    private Integer miniCharge;

    private Integer maxCharge;

    private boolean isNegotiable;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    private Byte delFlag;


    public Design() {
    }

    public Design(SaveDesignRequest param) {
        this.designerId = param.getDesignerId();
        this.type = param.getType();
        this.name = param.getName();
        this.brief = param.getBrief();
        this.createTime = new Date();
        this.maxCharge = param.getMaxCharge();
        this.miniCharge = param.getMiniCharge();
        this.isNegotiable = param.isNegotiable();
    }
}