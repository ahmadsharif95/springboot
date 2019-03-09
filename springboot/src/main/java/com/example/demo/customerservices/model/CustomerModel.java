package com.example.demo.customerservices.model;

import com.example.demo.accountservices.daos.CustomerAccount;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

public class CustomerModel {
    private Long customerNumber;

    private String civilId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date dateOfBirth;

    private String fullName;

    private String mobileNumber;

    private List<CustomerAccount> accounts;

    public List<CustomerAccount> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<CustomerAccount> accounts) {
        this.accounts = accounts;
    }

    public Long getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(Long customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getCivilId() {
        return civilId;
    }

    public void setCivilId(String civilId) {
        this.civilId = civilId;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
}
