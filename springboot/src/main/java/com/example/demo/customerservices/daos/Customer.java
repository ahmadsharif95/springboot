package com.example.demo.customerservices.daos;

import com.example.demo.accountservices.daos.CustomerAccount;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Customer {

    @Id
    @GeneratedValue
    private Long customerNumber;

    private String civilId;

    private Date dateOfBirth;

    private String fullName;

    private String mobileNumber;

    @OneToMany(mappedBy = "refCustomer",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<CustomerAccount> accounts = new ArrayList<>();

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

    @JsonIgnore
    public List<CustomerAccount> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<CustomerAccount> accounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerNumber=" + customerNumber +
                ", civilId='" + civilId + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", fullName='" + fullName + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                '}';
    }
}
