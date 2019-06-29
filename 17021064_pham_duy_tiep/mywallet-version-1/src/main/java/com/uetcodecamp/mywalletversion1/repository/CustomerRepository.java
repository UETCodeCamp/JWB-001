package com.uetcodecamp.mywalletversion1.repository;

import com.uetcodecamp.mywalletversion1.model.Customer;
import org.springframework.data.annotation.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByNameContaining(String name);
}
