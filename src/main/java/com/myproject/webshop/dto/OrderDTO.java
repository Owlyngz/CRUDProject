package com.myproject.webshop.dto;

import java.time.LocalDate;

public class OrderDTO {

    private Long orderId;
    private LocalDate ordered;
    private LocalDate shipped;
    private String shipTo;
    private String orderStatus;

    public OrderDTO(Long orderId, LocalDate ordered, LocalDate shipped, String shipTo, String orderStatus) {
        this.orderId = orderId;
        this.ordered = ordered;
        this.shipped = shipped;
        this.shipTo = shipTo;
        this.orderStatus = orderStatus;
    }

    public OrderDTO(LocalDate ordered, LocalDate shipped, String shipTo, String orderStatus) {
        this.ordered = ordered;
        this.shipped = shipped;
        this.shipTo = shipTo;
        this.orderStatus = orderStatus;
    }


    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public LocalDate getOrdered() {
        return ordered;
    }

    public void setOrdered(LocalDate ordered) {
        this.ordered = ordered;
    }

    public LocalDate getShipped() {
        return shipped;
    }

    public void setShipped(LocalDate shipped) {
        this.shipped = shipped;
    }

    public String getShipTo() {
        return shipTo;
    }

    public void setShipTo(String shipTo) {
        this.shipTo = shipTo;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
}
