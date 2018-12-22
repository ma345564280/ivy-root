package com.ivy.root.common.rootenum;
/**
 * @author gaoxin
 *
 */
public enum HardPurchaseOrderEnum {

    PURCHASE_WAITING(10, "采购待接单"),

    PURCHASED_CANCEL(15, "厂家接单退回"),

    SHIPMENT_WAITING(20, "厂家待出货"),

    SHIPMENT_COMPLETED(25, "厂家出货完成"),

    PURCHASE_CANCEL(30, "采购取消");

    private int code;

    private String description;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    HardPurchaseOrderEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public static HardPurchaseOrderEnum getStatus(Integer code) {
        if (code != null) {
            for (HardPurchaseOrderEnum element : HardPurchaseOrderEnum.values()) {
                if (element.getCode() == code) {
                    return element;
                }
            }
        }
        return null;
    }

    public static String getDescription(Integer code) {
        if (code != null) {
            for (HardPurchaseOrderEnum element : values()) {
                if (element.getCode() == code) {
                    return element.getDescription();
                }
            }
        }
        return null;
    }


}
