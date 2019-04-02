package com.myproject.webshop.model;

import javax.persistence.*;

@Entity

public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long pId;
    private String uName;
    private String bankName;
    private int cardNo;
    private byte ccv;

    @OneToOne
    @JoinColumn(name = "order.id")
    private Order order;

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cart")
//    private List<CartDetails> cartDetailsList;

    @OneToOne
    @JoinColumn(name = "user.id")
    private User user;

    public Payment(Long pId, String uName, String bankName, int cardNo, byte ccv) {
        this.pId = pId;
        this.uName = uName;
        this.bankName = bankName;
        this.cardNo = cardNo;
        this.ccv = ccv;
    }

    public Payment(String uName, String bankName, int cardNo, byte ccv) {
        this.uName = uName;
        this.bankName = bankName;
        this.cardNo = cardNo;
        this.ccv = ccv;
    }


    public Long getpId() {
        return pId;
    }

    public void setpId(Long pId) {
        this.pId = pId;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public int getCardNo() {
        return cardNo;
    }

    public void setCardNo(int cardNo) {
        this.cardNo = cardNo;
    }

    public byte getCcv() {
        return ccv;
    }

    public void setCcv(byte ccv) {
        this.ccv = ccv;
    }
}
