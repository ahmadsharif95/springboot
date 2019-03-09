package com.example.demo.accountservices.model;

public class AccountModel {
    private Long accountNumber;

    private String currency;

    private Integer accountType;


    private Long refCustomerNumber;

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Integer getAccountType() {
        return accountType;
    }

    public void setAccountType(Integer accountType) {
        this.accountType = accountType;
    }

    public Long getRefCustomerNumber() {
        return refCustomerNumber;
    }

    public void setRefCustomerNumber(Long refCustomerNumber) {
        this.refCustomerNumber = refCustomerNumber;
    }
}
