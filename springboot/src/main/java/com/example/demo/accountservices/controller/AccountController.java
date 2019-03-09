package com.example.demo.accountservices.controller;

import com.example.demo.accountservices.daos.CustomerAccount;
import com.example.demo.accountservices.model.AccountModel;
import com.example.demo.accountservices.services.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class AccountController implements IAccountContoller {
    private static final Logger LOG = LoggerFactory.getLogger("JCG");
    @Autowired
    private AccountService accountService;

    @RequestMapping("/account/customerAccountsByCustomerNumber")
    @Override
    public List<AccountModel> getAllCustomerAccountsByCustomerNumber(@RequestParam(value = "customerNumber") Long customerNumber) {
        return accountService.getAllCustomerAccountsByCustomerNumber(customerNumber);
    }

    @RequestMapping("/account/getAllCustomerAccountsByCivilId")
    @Override
    public List<AccountModel> getAllCustomerAccountsByCivilId(@RequestParam String civilId) {
        return accountService.getAllCustomerAccountsByCivilId(civilId);
    }

    @RequestMapping(value = "/account/CreateAccount", method = RequestMethod.POST)
    @Override
    public CustomerAccount addNewCustomerAccount(@RequestBody AccountModel accountModel) {
        return accountService.createAccount(accountModel);
    }

    @RequestMapping("/account/updateAccount")
    @Override
    public CustomerAccount updateCustomerAccount(@RequestBody AccountModel account) {
        return accountService.editAccount(account);
    }

    @RequestMapping("/account/deleteAccount")
    @Override
    public String deleteCustomerAccount(@RequestParam Long accountNumber) {
        accountService.deleteAccount(accountNumber);
        return "the account has been deleted";
    }

    @RequestMapping("/account/getCustomerBalanceInformation")
    @Override
    public Map<String, Double> getCustomerBalanceInformation(@RequestParam Long accountNumber) {
        CustomerAccount account = accountService.getAccount(accountNumber);
        Map<String, Double> data = new HashMap<>();
        data.put("balanceBefore", account.getCurrentBalance());
        data.put("currentBalance", account.getCurrentBalance());
        return data;
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public final String exceptionHandlerIllegalArgumentException(final IllegalArgumentException e) {
        return '"' + e.getMessage() + '"';
    }


}
