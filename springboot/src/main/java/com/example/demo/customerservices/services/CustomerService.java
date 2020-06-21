package com.example.demo.customerservices.services;

import com.example.demo.customerservices.Utilities.CustomerUtilities;
import com.example.demo.customerservices.customervalidator.CustomerValidatorResult;
import com.example.demo.customerservices.customervalidator.ValidateCustomer;
import com.example.demo.customerservices.daos.Customer;
import com.example.demo.customerservices.model.CustomerModel;
import com.example.demo.customerservices.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {
    private CustomerUtilities customerUtilities = new CustomerUtilities();

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer createCustomer(CustomerModel customerModel) {
        CustomerValidatorResult customerValidatorResult = ValidateCustomer.validateCustomer(customerModel, customerRepository);
        if (!customerValidatorResult.isValid())
            throw new IllegalArgumentException(customerValidatorResult.getReason());
        return customerRepository.save(customerUtilities.getCustomerDaoToBeCreated(customerModel));
    }

    @Override
    public Customer getCustomer(Long id) {
        return customerRepository.getOne(id);
    }

    @Override
    public Customer editCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(Customer customer) {
        customerRepository.delete(customer);
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.delete(customerRepository.getOne(id));
    }


}