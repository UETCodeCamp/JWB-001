package com.uetcodecamp.vuvanhoc.service;

import com.uetcodecamp.vuvanhoc.model.Customer;
import com.uetcodecamp.vuvanhoc.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	public Customer getCustomerById(int id){
		return customerRepository.getOne(id);
	}

	public List<Customer> getAllCustomer(){
		return customerRepository.findAll();
	}

	public void addNewUser(Customer customer){
		customerRepository.save(customer);
	}

	public void deleteUserById(int id){
		Optional<Customer> customer = customerRepository.findById(id);
		if(!customer.isPresent()){
			System.out.println("Customer not found");
			return;
		}
		customerRepository.delete(customer.get());
	}
}
