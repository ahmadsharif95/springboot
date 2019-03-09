package com.example.demo;

import com.example.demo.customerservices.model.CustomerModel;
import com.example.demo.customerservices.services.ICustomerService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@SpringBootApplication
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CustomerServiceTest.class, properties = "spring.main.allow-bean-definition-overriding=true")
public class CustomerServiceTest {

    @Autowired
    private ICustomerService customerService;

    @Test
    public void canCreateNewCustomer() throws ParseException {
        CustomerModel customer = new CustomerModel();
        customer.setFullName("Ahmad Alsharif");
        customer.setCivilId("86621144");
        customer.setMobileNumber("00962787150144");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        customer.setDateOfBirth(sdf.parse("25-07-1995"));
        Assert.assertNotNull(customerService.createCustomer(customer));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenPassedNullCivilIdTheMethodShouldThrowIllegalArgumentException() throws ParseException {
        CustomerModel customer = new CustomerModel();
        customer.setFullName("Ahmad Alsharif");
        customer.setMobileNumber("00962787150146");
        customer.setCivilId(null);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        customer.setDateOfBirth(sdf.parse("25-07-1995"));
        customerService.createCustomer(customer);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenPassingNullMobileNumberTheMethodShouldThrowIllegalArgumentException() throws ParseException {
        CustomerModel customer = new CustomerModel();
        customer.setFullName("Ahmad Alsharif");
        customer.setMobileNumber(null);
        customer.setCivilId("123456789");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        customer.setDateOfBirth(sdf.parse("25-07-1995"));
        customerService.createCustomer(customer);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenPassingNullFullNameTheMethodShouldThrowIllegalArgumentException() throws ParseException {
        CustomerModel customer = new CustomerModel();
        customer.setFullName(null);
        customer.setMobileNumber("0787150120");
        customer.setCivilId("123456789");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        customer.setDateOfBirth(sdf.parse("25-07-1995"));
        customerService.createCustomer(customer);
    }

    @Test(expected = IllegalStateException.class)
    public void whenPassedNullCustomerMethodShouldThrowIllegalStateException() {
        customerService.createCustomer(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenCreateTwoCustomerWithTheSameCivilIdTheMethodShouldThrowIllegalArgumentException() throws ParseException {
        CustomerModel customer = new CustomerModel();
        customer.setFullName("Ahmad Alsharif");
        customer.setCivilId("123456789");
        customer.setMobileNumber("00962787150154");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        customer.setDateOfBirth(sdf.parse("25-07-1995"));

        CustomerModel customer2 = new CustomerModel();
        customer.setFullName("Samer Ali");
        customer.setCivilId("123456789");
        customer.setMobileNumber("0962787150155");
        customer.setDateOfBirth(sdf.parse("29-08-1990"));

        customerService.createCustomer(customer);
        customerService.createCustomer(customer2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenCreateTwoCustomerWithTheSameMobileNumberTheMethodShouldThrowIllegalArgumentException() throws ParseException {
        CustomerModel customer = new CustomerModel();
        customer.setFullName("Ahmad Alsharif");
        customer.setCivilId("123456789");
        customer.setMobileNumber("00962787150101");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        customer.setDateOfBirth(sdf.parse("25-07-1995"));

        CustomerModel customer2 = new CustomerModel();
        customer.setFullName("Samer Ali");
        customer.setCivilId("7878454521");
        customer.setMobileNumber("00962787150101");
        customer.setDateOfBirth(sdf.parse("29-08-1990"));

        customerService.createCustomer(customer);
        customerService.createCustomer(customer2);
    }


    @Test(expected = IllegalArgumentException.class)
    public void whenCreateTwoCustomerWithTheSameCustomerNumberTheMethodShouldThrowIllegalArgumentException() throws ParseException {
        CustomerModel customer = new CustomerModel();
        customer.setCustomerNumber(10L);
        customer.setFullName("Ahmad Alsharif");
        customer.setCivilId("123456789");
        customer.setMobileNumber("00962787150144");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        customer.setDateOfBirth(sdf.parse("25-07-1995"));

        CustomerModel customer2 = new CustomerModel();
        customer2.setCustomerNumber(10L);
        customer.setFullName("Samer Ali");
        customer.setCivilId("9879632");
        customer.setMobileNumber("0962787150155");
        customer.setDateOfBirth(sdf.parse("29-08-1990"));

        customerService.createCustomer(customer);
        customerService.createCustomer(customer2);
    }


}
