package com.example.demo.customerservices.controller;

import com.example.demo.customerservices.daos.Customer;
import com.example.demo.customerservices.model.CustomerModel;
import com.example.demo.customerservices.services.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController implements ICustomerController {

    @Autowired
    private ICustomerService customerService;

    @RequestMapping(value = "/customer/CreateCustomer", method = RequestMethod.POST)
    @Override
    public Customer addNewCustomer(@RequestBody CustomerModel customerModel) {

        return customerService.createCustomer(customerModel);
    }

}
