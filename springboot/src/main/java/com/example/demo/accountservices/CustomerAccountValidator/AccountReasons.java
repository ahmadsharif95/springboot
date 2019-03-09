package com.example.demo.accountservices.CustomerAccountValidator;

import com.example.demo.customerservices.customervalidator.CustomerValidatorResult;

public enum AccountReasons {
    VALID(new CustomerValidatorResult(true, "valid")),
    CURRENCY_CANNOT_BE_NULL(new CustomerValidatorResult(false, "currency cannot be null")),
    ACCOUNT_TYPE_CANNOT_BE_NULL(new CustomerValidatorResult(false, "accountType cannot be null")),
    INVALID_CUSTOMER_NUMBER(new CustomerValidatorResult(false, "customerNumber Invalid")),
    INVALID_ACCOUNT_NUMBER(new CustomerValidatorResult(false, "accountNumber Invalid")),
    ACCOUNT_NUMBER_CANNOT_BE_NULL(new CustomerValidatorResult(false, "accountNumber Cannot be null")),
    CIVIL_ID_CANNOT_BE_NULL(new CustomerValidatorResult(false, "civilId cannot be null"));

    private CustomerValidatorResult customerValidatorResponse;

    AccountReasons(CustomerValidatorResult customerValidatorResponse) {
        this.customerValidatorResponse = customerValidatorResponse;
    }

    public CustomerValidatorResult getCustomerValidatorResult() {
        return customerValidatorResponse;
    }

    public enum ACCOUNT_NUMBER_CANNOT_BE_NULL {}
}
