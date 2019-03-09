package com.example.demo.customerservices.customervalidator;

import com.example.demo.customerservices.daos.Customer;
import com.example.demo.customerservices.model.CustomerModel;
import com.example.demo.customerservices.repository.CustomerRepository;

import java.util.Objects;
import java.util.Optional;

public class ValidateCustomer {
    public static CustomerValidatorResult validateCustomer(CustomerModel customer, CustomerRepository customerRepository) {
        if (Objects.isNull(customer))
            throw new IllegalStateException();

        if (isEmpty(customer.getCivilId()))
            return Reasons.CIVIL_ID_CANNOT_BE_NULL.getCustomerValidatorResponse();

        if (isEmpty(customer.getMobileNumber()))
            return Reasons.MOBILE_NUMBER_CANNOT_BE_NULL.getCustomerValidatorResponse();

        if (isEmpty(customer.getFullName()))
            return Reasons.FULL_NAME_CANNOT_BE_NULL.getCustomerValidatorResponse();

        Customer customerByCivilId = customerRepository.getCustomerByCivilId(customer.getCivilId());
        if (Objects.nonNull(customerByCivilId))
            return Reasons.CUSTOMER_ALREADY_REGISTERED.getCustomerValidatorResponse();

        Customer customerByMobileNumber = customerRepository.getCustomerByMobileNumber(customer.getMobileNumber());
        if (Objects.nonNull(customerByMobileNumber))
            return Reasons.CUSTOMER_ALREADY_REGISTERED.getCustomerValidatorResponse();

        if (Objects.nonNull(customer.getCustomerNumber())) {
            Optional<Customer> customerById = customerRepository.findById(customer.getCustomerNumber());
            if (customerById.isPresent())
                return Reasons.CUSTOMER_ALREADY_REGISTERED.getCustomerValidatorResponse();
        }

        return Reasons.VALID.getCustomerValidatorResponse();
    }

    private static boolean isEmpty(String civilId) {
        return Objects.isNull(civilId) || civilId.isEmpty();
    }
}
