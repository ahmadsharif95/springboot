package com.example.demo.accountservices.services;

import com.example.demo.accountservices.daos.CustomerAccount;
import com.example.demo.accountservices.model.AccountModel;

import java.util.List;

public interface IAccountService {


    CustomerAccount createAccount(AccountModel accountModel);

    CustomerAccount getAccount(Long id);

    CustomerAccount editAccount(AccountModel customerAccount);

    void deleteAccount(Long id);

    List<AccountModel> getAllCustomerAccountsByCustomerNumber(Long customerNumber);

    List<AccountModel> getAllCustomerAccountsByCivilId(String civilId);
}