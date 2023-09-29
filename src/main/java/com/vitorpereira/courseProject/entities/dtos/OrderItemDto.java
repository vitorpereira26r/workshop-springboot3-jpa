package com.vitorpereira.courseProject.entities.dtos;

import com.vitorpereira.courseProject.entities.Order;
import com.vitorpereira.courseProject.entities.OrderItem;
import com.vitorpereira.courseProject.entities.Product;

public class OrderItemDto {

    private Integer quantity;
    private Double price;

    private Long orderId;
    private Long productId;

    public OrderItemDto() {
    }

    public OrderItemDto(Integer quantity, Double price, Long orderId, Long productId) {
        this.quantity = quantity;
        this.price = price;
        this.orderId = orderId;
        this.productId = productId;
    }

    public OrderItemDto(OrderItem orderItem){
        this.orderId = orderItem.getOrder().getId();
        this.productId = orderItem.getProduct().getId();
        this.price = orderItem.getPrice();
        this.quantity = orderItem.getQuantity();
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
