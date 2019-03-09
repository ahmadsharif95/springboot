package com.example.demo.customerservices.Utilities;

import com.example.demo.customerservices.daos.Customer;
import com.example.demo.customerservices.model.CustomerModel;

public class CustomerUtilities {

    public Customer getCustomerDaoToBeCreated(CustomerModel customerModel) {
        Customer customer = new Customer();
        customer.setCivilId(customer.getCivilId());
        customer.setDateOfBirth(customerModel.getDateOfBirth());
        customer.setFullName(customerModel.getFullName());
        customer.setMobileNumber(customerModel.getMobileNumber());
        customer.setCivilId(customerModel.getCivilId());
        return customer;
    }
}
