package com.example.demo.accountservices.services;

import com.example.demo.accountservices.CustomerAccountValidator.AccountReasons;
import com.example.demo.accountservices.CustomerAccountValidator.ValidateCustomerAccount;
import com.example.demo.accountservices.daos.CustomerAccount;
import com.example.demo.accountservices.model.AccountModel;
import com.example.demo.accountservices.repository.AccountRepository;
import com.example.demo.accountservices.utilities.AccountUtilities;
import com.example.demo.customerservices.customervalidator.CustomerValidatorResult;
import com.example.demo.customerservices.daos.Customer;
import com.example.demo.customerservices.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AccountService implements IAccountService {
    private AccountUtilities accountUtil = new AccountUtilities();

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public CustomerAccount createAccount(AccountModel accountModel) {
        CustomerAccount customerAccount = convertAccountModelToAccountDaoToBeCreated(accountModel);
        CustomerValidatorResult customerValidatorResult = ValidateCustomerAccount.validateCustomerAccount(customerAccount);
        if (!customerValidatorResult.isValid())
            throw new IllegalArgumentException(customerValidatorResult.getReason());
        customerAccount.setCurrentBalance(0D);
        customerAccount.setPreviousBalance(0D);
        return accountRepository.save(customerAccount);
    }

    @Override
    public CustomerAccount getAccount(Long id) {
        Optional<CustomerAccount> customerAccount = accountRepository.findById(id);
        isNull(!customerAccount.isPresent(), AccountReasons.INVALID_ACCOUNT_NUMBER);
        return customerAccount.get();
    }

    @Override
    public CustomerAccount editAccount(AccountModel accountModel) {
        CustomerAccount customerAccount = convertAccountModelToAccountDaoTobeEdited(accountModel);
        CustomerValidatorResult customerValidatorResult = ValidateCustomerAccount.validateCustomerAccount(customerAccount);
        isValid(customerValidatorResult, !customerValidatorResult.isValid());
        return accountRepository.save(customerAccount);
    }

    @Override
    public void deleteAccount(Long id) {
        //TODO we should validate the balance before delete it but this is just an example
        isNull(Objects.isNull(id), AccountReasons.ACCOUNT_NUMBER_CANNOT_BE_NULL);
        CustomerAccount customerAccount = getAccount(id);
        isNull(Objects.isNull(customerAccount), AccountReasons.INVALID_ACCOUNT_NUMBER);
        accountRepository.delete(accountRepository.getOne(id));
    }

    @Override
    public List<AccountModel> getAllCustomerAccountsByCustomerNumber(Long customerNumber) {
        isNull(Objects.isNull(customerNumber), AccountReasons.INVALID_CUSTOMER_NUMBER);
        List<CustomerAccount> accountByCustomerNumber = accountRepository.getAccountByCustomerNumber(customerNumber);
        return accountUtil.getListOfAccountsModelResponse(accountByCustomerNumber);
    }

    @Override
    public List<AccountModel> getAllCustomerAccountsByCivilId(String civilId) {
        isNull(Objects.isNull(civilId), AccountReasons.CIVIL_ID_CANNOT_BE_NULL);
        return accountUtil.getListOfAccountsModelResponse(accountRepository.getAllCustomerAccountsByCivilId(civilId));
    }

    private CustomerAccount convertAccountModelToAccountDaoToBeCreated(AccountModel accountModel) {
        isNull(Objects.isNull(accountModel.getRefCustomerNumber()), AccountReasons.INVALID_CUSTOMER_NUMBER);
        Optional<Customer> customer = customerRepository.findById(accountModel.getRefCustomerNumber());
        CustomerAccount accountDao = new CustomerAccount();
        isNull(!customer.isPresent(), AccountReasons.INVALID_CUSTOMER_NUMBER);
        accountDao.setCurrency(accountModel.getCurrency());
        accountDao.setAccountType(accountModel.getAccountType());
        accountDao.setRefCustomer(customer.get());
        return accountDao;
    }

    private CustomerAccount convertAccountModelToAccountDaoTobeEdited(AccountModel accountModel) {
        CustomerAccount account = getAccount(accountModel.getAccountNumber());
        account.setCurrency(accountModel.getCurrency());
        account.setAccountType(accountModel.getAccountType());
        return account;
    }

    private void isNull(boolean isNull, AccountReasons accountNumberCannotBeNull) {
        if (isNull)
            throw new IllegalArgumentException(accountNumberCannotBeNull.getCustomerValidatorResult().getReason());
    }

    private void isValid(CustomerValidatorResult customerValidatorResult, boolean isNotValid) {
        if (isNotValid) throw new IllegalArgumentException(customerValidatorResult.getReason());
    }


}