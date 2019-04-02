package com.myproject.webshop.dto;

import java.time.LocalDate;

public class DTO {

    public class UserDTO {

        private Long id;
        private String userName;
        private String userSurname;
        private String userEmail;
        private String password;
        private AccountDTO Account;

        public UserDTO(AccountDTO account) {
            Account = account;
        }

        public UserDTO(Long id, String userName, String userSurname, String userEmail, String password) {
            this.id = id;
            this.userName = userName;
            this.userSurname = userSurname;
            this.userEmail = userEmail;
            this.password = password;
        }

        public AccountDTO getAccount() {
            return Account;
        }

        public void setAccount(AccountDTO account) {
            Account = account;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getUserSurname() {
            return userSurname;
        }

        public void setUserSurname(String userSurname) {
            this.userSurname = userSurname;
        }

        public String getUserEmail() {
            return userEmail;
        }

        public void setUserEmail(String userEmail) {
            this.userEmail = userEmail;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

    public class AccountDTO {

        private Long accId;
        private String billingAdress;
        private LocalDate openDate;
        private LocalDate closedDate;
        private OrderDTO order;

        public AccountDTO(OrderDTO order) {
            this.order = order;
        }

        public OrderDTO getOrder() {
            return order;
        }

        public void setOrder(OrderDTO order) {
            this.order = order;
        }

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

    public class PaymentDTO {


        private Long pId;
        private String uName;
        private String bankName;
        private int cardNo;
        private byte ccv;
        private AccountDTO account;

        public PaymentDTO(AccountDTO account) {
            this.account = account;
        }

        public AccountDTO getAccount() {
            return account;
        }

        public void setAccount(AccountDTO account) {
            this.account = account;
        }

        public PaymentDTO(Long pId, String uName, String bankName, int cardNo, byte ccv) {
            this.pId = pId;
            this.uName = uName;
            this.bankName = bankName;
            this.cardNo = cardNo;
            this.ccv = ccv;
        }

        public PaymentDTO(String uName, String bankName, int cardNo, byte ccv) {
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

}
