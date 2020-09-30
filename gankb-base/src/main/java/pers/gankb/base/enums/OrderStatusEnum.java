package pers.gankb.base.enums;

/**
 * @description: 写个订单状态的枚举类
 * @author: Gandaif
 * @date: 2020/9/3
 */
public enum OrderStatusEnum {
    ORDER_STATUS_PENDING_SERVICE(5, "待服务"),
    ORDER_STATUS_COMPLETED(10, "已完成"), // 已完成未结算
    ORDER_STATUS_SETTLED(15, "已结算"),
    ORDER_STATUS_CANCELLED(20, "已取消");


    private Integer status; // 状态
    private String desc; //状态描述

    // 枚举的构造器没有public修饰符
    OrderStatusEnum(Integer status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public static String getDesc(Integer type) {
        if (type == null) {
            return null;
        }
        OrderStatusEnum[] enums = OrderStatusEnum.values();
        for (OrderStatusEnum orderStatusEnum : enums) {
            if (type.equals(orderStatusEnum.getStatus())) {
                return orderStatusEnum.getDesc();
            }
        }
        return null;
    }

    public Integer getStatus() {
        return status;
    }

    public String getDesc() {
        return desc;
    }
}
