package com.example.demo.customerservices.services;


import com.example.demo.customerservices.daos.Customer;
import com.example.demo.customerservices.model.CustomerModel;

public interface ICustomerService {

    Customer createCustomer(CustomerModel customerModel);

    Customer getCustomer(Long id);

    Customer editCustomer(Customer customer);

    void deleteCustomer(Customer customer);

    void deleteCustomer(Long id);
}