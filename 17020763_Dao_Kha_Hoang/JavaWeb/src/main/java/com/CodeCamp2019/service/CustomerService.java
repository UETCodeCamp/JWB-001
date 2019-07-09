package com.CodeCamp2019.service;

import com.CodeCamp2019.model.Customer;
import com.CodeCamp2019.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    public List<Customer> findAll(){
        return customerRepository.findAll();
    }
    public void save(Customer customer){ customerRepository.save(customer);}
    public Customer getOne(int id){return customerRepository.getOne(id);}
    public void deleteCustomer(int id){
        customerRepository.delete(customerRepository.getOne(id));
    }
    public List<Customer>  search(String name){ return customerRepository.findByNameContaining(name);}

}
