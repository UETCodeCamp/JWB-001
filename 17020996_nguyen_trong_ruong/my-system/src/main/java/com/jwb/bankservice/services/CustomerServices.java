package com.jwb.bankservice.services;

import com.jwb.bankservice.models.Customer;
import com.jwb.bankservice.repositories.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServices {
    @Autowired
    private CustomerRepository customerRepository;

    public Customer getCustomer(int id){
        return customerRepository.getOne(id);
    }

    public List<Customer> getAllCustomer(){
        return customerRepository.findAll();
    }

    public void addCustomer(Customer ctm){
        customerRepository.save(ctm);
    }

    public void delCustomerList(int id){
        customerRepository.deleteById(id);
    }

    public void editCustomer(Customer customer){
        customerRepository.save(customer);
    }

    public void logout(int id){
        Customer c = customerRepository.getOne(id);
        c.setLogin(0);
        customerRepository.save(c);
    }

    public boolean login(int id, String pass){
        Customer c = customerRepository.getOne(id);
        if (c.getPassword().equals(pass)){
            c.setLogin(1);
            customerRepository.save(c);
            return true;
        }
        return false;
    }

    public void transferMoney(int sId, int rId, int amount){
        Customer sentCustomer = customerRepository.getOne(sId);
        Customer receivedCustomer = customerRepository.getOne(rId);
        sentCustomer.transferMoney(amount);
        receivedCustomer.receiveMoney(amount);
        customerRepository.save(sentCustomer);
        customerRepository.save(receivedCustomer);
    }

    public List<String> search(String data){
        String result = new String();
        
        List<String> listResult = new ArrayList<>();
        for(Customer customer : getAllCustomer()){
            if (customer.getName().contains(data) || customer.getEmail().contains(data) || customer.getPhoneNumber().contains(data)){
                result += "<tr> <td>" + customer.getName() + "</td> <td>" + customer.getEmail() + "</td> <td>" + customer.getPhoneNumber() + "</td> <td><a href=\"/editing-form?customerId=" + customer.getId() + "\">Edit</a> </td></tr>";
                listResult.add(result);
                result = "";
            }
        }
        return listResult;
    }
}