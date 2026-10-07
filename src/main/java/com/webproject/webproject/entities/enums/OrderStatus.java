package com.webproject.webproject.entities.enums;

import org.jspecify.annotations.NonNull;

public enum OrderStatus {
    WAITING_PAYMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);

    private Integer code;

    private OrderStatus(Integer code){
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public static @NonNull OrderStatus valueOf(Integer code){
        for(OrderStatus orderStatus : OrderStatus.values()){
            if(orderStatus.getCode() == code){
                return orderStatus;
            }
        }
        throw new IllegalArgumentException();
    }
}
