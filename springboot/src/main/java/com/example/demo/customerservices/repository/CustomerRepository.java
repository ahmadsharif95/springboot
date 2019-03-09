package com.example.demo.customerservices.repository;

import com.example.demo.customerservices.daos.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("SELECT a FROM Customer a where mobileNumber = :mobileNumber")
    Customer getCustomerByMobileNumber(@Param("mobileNumber") String mobileNumber);

    @Query("SELECT a FROM Customer a where civilId = :civilId")
    Customer getCustomerByCivilId(@Param("civilId") String civilId);

}