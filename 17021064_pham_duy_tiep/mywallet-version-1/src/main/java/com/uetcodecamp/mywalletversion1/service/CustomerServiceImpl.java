package com.uetcodecamp.mywalletversion1.service;

import com.uetcodecamp.mywalletversion1.model.Customer;
import com.uetcodecamp.mywalletversion1.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Transactional
    public List<Customer> getAllCustomer(){
        return customerRepository.findAll();
    }

    @Override
    public List<Customer> findByNameContaining(String name){
        return customerRepository.findByNameContaining(name);
    }
}
