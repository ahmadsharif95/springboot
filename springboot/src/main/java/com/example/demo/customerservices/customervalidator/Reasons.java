package com.example.demo.customerservices.customervalidator;

public enum Reasons {
    FULL_NAME_CANNOT_BE_NULL(new CustomerValidatorResult(false, "full name cannot be null")),
    CIVIL_ID_CANNOT_BE_NULL(new CustomerValidatorResult(false, "civilId cannot be null")),
    MOBILE_NUMBER_CANNOT_BE_NULL(new CustomerValidatorResult(false, "mobile number cannot be null")),
    VALID(new CustomerValidatorResult(true, "valid")),
    CUSTOMER_ALREADY_REGISTERED(new CustomerValidatorResult(false, "customer Already registered"));

    private CustomerValidatorResult customerValidatorResponse;

    Reasons(CustomerValidatorResult customerValidatorResponse) {
        this.customerValidatorResponse = customerValidatorResponse;
    }

    public CustomerValidatorResult getCustomerValidatorResponse() {
        return customerValidatorResponse;
    }
}
