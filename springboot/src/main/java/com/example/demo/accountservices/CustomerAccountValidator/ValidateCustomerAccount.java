package com.example.demo.accountservices.CustomerAccountValidator;

import com.example.demo.accountservices.daos.CustomerAccount;
import com.example.demo.customerservices.customervalidator.CustomerValidatorResult;

import java.util.Objects;

public class ValidateCustomerAccount {
    public static CustomerValidatorResult validateCustomerAccount(CustomerAccount account) {
        if (Objects.isNull(account))
            throw new IllegalStateException();

        if (isEmpty(account.getCurrency()))
            return AccountReasons.CURRENCY_CANNOT_BE_NULL.getCustomerValidatorResult();

        if (Objects.isNull(account.getAccountType()))
            return AccountReasons.ACCOUNT_TYPE_CANNOT_BE_NULL.getCustomerValidatorResult();

        if (Objects.isNull(account.getRefCustomer()))
            return AccountReasons.INVALID_CUSTOMER_NUMBER.getCustomerValidatorResult();

        return AccountReasons.VALID.getCustomerValidatorResult();
    }

    private static boolean isEmpty(String str) {
        return Objects.isNull(str) || str.trim().isEmpty();
    }
}
