package com.example.demo.accountservices.controller;

import com.example.demo.accountservices.daos.CustomerAccount;
import com.example.demo.accountservices.model.AccountModel;

import java.util.List;
import java.util.Map;

public interface IAccountContoller {

    List<AccountModel> getAllCustomerAccountsByCustomerNumber(Long customerNumber);

    List<AccountModel> getAllCustomerAccountsByCivilId(String civilId);

    CustomerAccount addNewCustomerAccount(AccountModel accountModel);

    CustomerAccount updateCustomerAccount(AccountModel account);

    String deleteCustomerAccount(Long accountNumber);

    Map<String, Double> getCustomerBalanceInformation(Long customerAccount);
}
