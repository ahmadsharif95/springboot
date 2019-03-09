package com.example.demo.accountservices.daos;

import com.example.demo.customerservices.daos.Customer;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class CustomerAccount {

    @Id
    @GeneratedValue
    private Long accountNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "refCustomer", nullable = false)
    private Customer refCustomer;

    private String currency;

    private Integer accountType;

    private Double currentBalance;

    private Double previousBalance;

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    @JsonIgnore
    public Customer getRefCustomer() {
        return refCustomer;
    }

    public void setRefCustomer(Customer refCustomer) {
        this.refCustomer = refCustomer;
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

    public Double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(Double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public Double getPreviousBalance() {
        return previousBalance;
    }

    public void setPreviousBalance(Double previousBalance) {
        this.previousBalance = previousBalance;
    }
}
