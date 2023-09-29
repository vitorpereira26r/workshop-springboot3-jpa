package com.vitorpereira.courseProject.entities.dtos;

import com.vitorpereira.courseProject.entities.enums.OrderStatus;

public class OrderStatusDto {

    private String nameOrderStatus;
    private OrderStatus orderStatus;

    public OrderStatusDto() {
    }

    public OrderStatusDto(String nameOrderStatus){
        this.nameOrderStatus = nameOrderStatus;
        orderStatus = OrderStatus.valueOfString(nameOrderStatus);
    }

    public String getNameOrderStatus() {
        return nameOrderStatus;
    }

    public void setNameOrderStatus(String nameOrderStatus) {
        this.nameOrderStatus = nameOrderStatus;
        orderStatus = OrderStatus.valueOfString(nameOrderStatus);
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}
