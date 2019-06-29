package com.uetcodecamp.mywalletversion1.service;

import com.uetcodecamp.mywalletversion1.model.Customer;

import java.util.List;


public interface CustomerService {

    List<Customer> getAllCustomer();

    Customer getOne(Long id);

    void addCustomer(Customer contact);

    Customer checkLogin(String email, String password);

    Customer updateCustomer(Customer customerOld, Customer customerNew);

    void delete(Customer customer);

    List<Customer> search(String name);

}
