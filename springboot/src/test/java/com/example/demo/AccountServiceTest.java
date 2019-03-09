package com.example.demo;

import com.example.demo.accountservices.daos.CustomerAccount;
import com.example.demo.accountservices.model.AccountModel;
import com.example.demo.accountservices.services.IAccountService;
import com.example.demo.customerservices.daos.Customer;
import com.example.demo.customerservices.repository.CustomerRepository;
import com.example.demo.customerservices.services.ICustomerService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.Objects;

@SpringBootApplication
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AccountServiceTest.class, properties = "spring.main.allow-bean-definition-overriding=true")
public class AccountServiceTest {

    public static final int TAWFFER = 2;
    public static final int RAWATEB = 1;
    public static final String DOLLAR = "USD";
    public static final String DINNAR = "JOD";

    @Autowired
    private IAccountService accountService;

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private CustomerRepository customerRepository;

    private Customer persistedCustomer;

    @Before
    public void setUp() {
        Customer customer = new Customer();
        customer.setFullName("Ahmad Alsharif");
        customer.setDateOfBirth(new Date());
        customer.setMobileNumber("0787150144");
        customer.setCivilId("123");
        customer.setCustomerNumber(101L);
        persistedCustomer = customerRepository.saveAndFlush(customer);
    }

    @Test
    public void canCreateNewAccountAfterCreateCustomer() {
        AccountModel accountModel = getAccount();
        Assert.assertNotNull(accountService.createAccount(accountModel));
    }

    @Test
    public void canGetAllCustomerAccountsByCustomerNumberAfterCreateAccount() {
        AccountModel accountModel = getAccount();
        Assert.assertNotNull(accountService.createAccount(accountModel));
        Assert.assertNotNull(accountService.getAllCustomerAccountsByCustomerNumber(persistedCustomer.getCustomerNumber()));
    }

    @Test
    public void canGetAllCustomerAccountsByCivilIdAfterCreateAccount() {
        AccountModel accountModel = getAccount();
        Assert.assertNotNull(accountService.createAccount(accountModel));
        Assert.assertNotNull(accountService.getAllCustomerAccountsByCivilId(persistedCustomer.getCivilId()));
    }

    @Test
    public void canUpdateAccountAfterCreateIt() {
        AccountModel accountModel = getAccount();
        CustomerAccount account = accountService.createAccount(accountModel);
        Assert.assertNotNull(account);
        accountModel.setCurrency(DOLLAR);
        accountModel.setAccountType(TAWFFER);
        accountModel.setAccountNumber(account.getAccountNumber());
        CustomerAccount editedAccount = accountService.editAccount(accountModel);
        Assert.assertTrue(editedAccount.getAccountType().equals(TAWFFER));
        Assert.assertTrue(editedAccount.getCurrency().equals(DOLLAR));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenPassingInvalidCustomerNumberToCreateAccountTheMethodShouldThrowIllegalArgumentException() {
        AccountModel accountModel = getAccount();
        accountModel.setRefCustomerNumber(10000L);
        accountService.createAccount(accountModel);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenPassingNullCustomerNumberToCreateAccountTheMethodShouldThrowIllegalArgumentException() {
        AccountModel accountModel = getAccount();
        accountModel.setRefCustomerNumber(null);
        accountService.createAccount(accountModel);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenPassingNullCurrencyToCreateAccountTheMethodShouldThrowIllegalArgumentException() {
        AccountModel accountModel = getAccount();
        accountModel.setCurrency(null);
        accountService.createAccount(accountModel);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenPassingNullAccountTypeToCreateAccountTheMethodShouldThrowIllegalArgumentException() {
        AccountModel accountModel = getAccount();
        accountModel.setAccountType(null);
        accountService.createAccount(accountModel);
    }

    public void canDeleteAccountAfterCreateIt() {
        CustomerAccount account = getCustomerAccount();
        Assert.assertTrue(Objects.isNull(accountService.getAccount(account.getAccountNumber())));
    }

    private CustomerAccount getCustomerAccount() {
        AccountModel accountModel = getAccount();
        CustomerAccount account = accountService.createAccount(accountModel);
        Assert.assertNotNull(account);
        return account;
    }

    private AccountModel getAccount() {
        AccountModel accountModel = new AccountModel();
        accountModel.setAccountType(RAWATEB);
        accountModel.setRefCustomerNumber(persistedCustomer.getCustomerNumber());
        accountModel.setCurrency(DINNAR);
        return accountModel;
    }


}
