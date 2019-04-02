package com.myproject.webshop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long accId;
    private String billingAddress;
    private LocalDate openDate;
    private LocalDate closedDate;

    public Account(Long accId, String billingAddress, LocalDate openDate, LocalDate closedDate) {
        this.accId = accId;
        this.billingAddress = billingAddress;
        this.openDate = openDate;
        this.closedDate = closedDate;
    }

    public Account(String billingAddress, LocalDate openDate, LocalDate closedDate) {
        this.billingAddress = billingAddress;
        this.openDate = openDate;
        this.closedDate = closedDate;
    }

    public Account() {
    }

    public Long getAccId() {
        return accId;
    }

    public void setAccId(Long accId) {
        this.accId = accId;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public LocalDate getOpenDate() {
        return openDate;
    }

    public void setOpenDate(LocalDate openDate) {
        this.openDate = openDate;
    }

    public LocalDate getClosedDate() {
        return closedDate;
    }

    public void setClosedDate(LocalDate closedDate) {
        this.closedDate = closedDate;
    }
}
