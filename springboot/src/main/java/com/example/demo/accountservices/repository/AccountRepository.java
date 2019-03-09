package com.example.demo.accountservices.repository;


import com.example.demo.accountservices.daos.CustomerAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<CustomerAccount, Long> {

    @Query("SELECT a FROM CustomerAccount a  where refCustomer.customerNumber = :customerNumber")
    List<CustomerAccount> getAccountByCustomerNumber(@Param("customerNumber") Long customerNumber);

    @Query("SELECT a FROM CustomerAccount a  where refCustomer.civilId = :civilId")
    public List<CustomerAccount> getAllCustomerAccountsByCivilId(String civilId);
}