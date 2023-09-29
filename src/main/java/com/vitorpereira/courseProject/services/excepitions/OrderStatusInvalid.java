package com.vitorpereira.courseProject.services.excepitions;

public class OrderStatusInvalid extends RuntimeException{

    public OrderStatusInvalid(String orderStatus){
        super("Order Status " + orderStatus + " invalid.");
    }
}
