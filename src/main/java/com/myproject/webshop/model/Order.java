package com.myproject.webshop.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;
    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDate ordered;
    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDate shipped;
    private String shipTo;
    private String orderStatus;

    @OneToOne
    @JoinColumn(name = "account.id")
    private Account account;

    public Order(Long orderId, LocalDate ordered, LocalDate shipped, String shipTo, String orderStatus) {
        this.orderId = orderId;
        this.ordered = ordered;
        this.shipped = shipped;
        this.shipTo = shipTo;
        this.orderStatus = orderStatus;
    }

    public Order(LocalDate ordered, LocalDate shipped, String shipTo, String orderStatus) {
        this.ordered = ordered;
        this.shipped = shipped;
        this.shipTo = shipTo;
        this.orderStatus = orderStatus;
    }

    public Order() {
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
