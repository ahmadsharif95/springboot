package com.example.demo.accountservices.utilities;

import com.example.demo.accountservices.daos.CustomerAccount;
import com.example.demo.accountservices.model.AccountModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AccountUtilities {
    private AccountModel getAccountModel(CustomerAccount accountDao) {
        AccountModel account = new AccountModel();
        account.setAccountNumber(accountDao.getAccountNumber());
        account.setAccountType(accountDao.getAccountType());
        account.setCurrency(accountDao.getCurrency());
        return account;
    }


    public List<AccountModel> getListOfAccountsModelResponse(List<CustomerAccount> allCustomerAccountsByCustomerNumber) {
        List<AccountModel> data = new ArrayList<>();
        allCustomerAccountsByCustomerNumber.forEach(acc -> {
                    AccountModel account1 = getAccountModel(acc);
                    data.add(account1);
                }
        );
        return data;
    }

    public void validateIsNotNull(Object... objects) {
        for (Object obj : objects) {
            if (Objects.isNull(obj) || obj.equals(""))
                throw new IllegalArgumentException("{\"error\":\"At least one parameter is invalid or not supplied\"}");
        }
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public final String exceptionHandlerIllegalArgumentException(final IllegalArgumentException e) {
        return '"' + e.getMessage() + '"';
    }
}
