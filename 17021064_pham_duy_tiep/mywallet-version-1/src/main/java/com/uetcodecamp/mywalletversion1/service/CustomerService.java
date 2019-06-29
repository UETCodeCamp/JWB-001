package com.uetcodecamp.mywalletversion1.service;

import com.uetcodecamp.mywalletversion1.model.Customer;
import com.uetcodecamp.mywalletversion1.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {

    public List<Customer> getAllCustomer();

    public List<Customer> findByNameContaining(String name);

}
