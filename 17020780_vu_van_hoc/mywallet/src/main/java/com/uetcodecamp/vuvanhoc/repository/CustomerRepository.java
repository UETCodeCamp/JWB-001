package com.uetcodecamp.vuvanhoc.repository;

import com.uetcodecamp.vuvanhoc.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
