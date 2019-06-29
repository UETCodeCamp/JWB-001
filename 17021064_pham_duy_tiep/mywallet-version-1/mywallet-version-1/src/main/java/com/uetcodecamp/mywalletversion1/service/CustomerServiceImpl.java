package com.uetcodecamp.mywalletversion1.service;

import com.uetcodecamp.mywalletversion1.model.Customer;
import com.uetcodecamp.mywalletversion1.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getOne(Long id){
        return customerRepository.getOne(id);
    }

    @Override
    public void addCustomer(Customer customer){
        customerRepository.save(customer);
    }

    @Override
    public void delete(Customer customer) {
        customerRepository.delete(customer);
    }

    @Override
    public Customer updateCustomer(Customer customerOld, Customer customerNew){
        customerOld.setName(customerNew.getName());
        customerOld.setEmail(customerNew.getEmail());
        customerOld.setPhone(customerNew.getPhone());
        customerOld.setPassword(customerNew.getPassword());
        return customerRepository.save(customerOld);
    }

    @Override
    public Customer checkLogin(String email, String password){
        return customerRepository.findByEmailAndPassword(email, password);
    }

    @Override
    public List<Customer> search(String name) {
        return customerRepository.findByNameContaining(name);
    }
}
