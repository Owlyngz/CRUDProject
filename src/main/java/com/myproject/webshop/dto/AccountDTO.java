package com.myproject.webshop.dto;

import java.time.LocalDate;

public class AccountDTO {

    private Long accId;
    private String billingAdress;
    private LocalDate openDate;
    private LocalDate closedDate;

    public AccountDTO(Long accId, String billingAddress, LocalDate openDate, LocalDate closedDate) {
        this.accId = accId;
        this.billingAdress = billingAddress;
        this.openDate = openDate;
        this.closedDate = closedDate;
    }

    public AccountDTO(String billingAddress, LocalDate openDate, LocalDate closedDate) {
        this.billingAdress = billingAddress;
        this.openDate = openDate;
        this.closedDate = closedDate;
    }


    public Long getAccId() {
        return accId;
    }

    public void setAccId(Long accId) {
        this.accId = accId;
    }

    public String getBillingAdress() {
        return billingAdress;
    }

    public void setBillingAdress(String billingAdress) {
        this.billingAdress = billingAdress;
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


