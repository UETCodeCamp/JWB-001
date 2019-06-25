package com.jwb.bankservice.repositories;

import com.jwb.bankservice.models.Customer;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}