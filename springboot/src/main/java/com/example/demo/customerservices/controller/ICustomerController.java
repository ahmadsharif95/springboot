package com.example.demo.customerservices.controller;

import com.example.demo.customerservices.daos.Customer;
import com.example.demo.customerservices.model.CustomerModel;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface ICustomerController {

    @RequestMapping(value = "/CreateAccount", method = RequestMethod.POST)
    Customer addNewCustomer(@RequestBody CustomerModel customerModel);
}
