package com.ivy.root.common.request;

public class DesignsParamRequest extends PageRequest {
    public Long designerId;

    public Long getDesignerId() {
        return designerId;
    }

    public void setDesignerId(Long designerId) {
        this.designerId = designerId;
    }
}
