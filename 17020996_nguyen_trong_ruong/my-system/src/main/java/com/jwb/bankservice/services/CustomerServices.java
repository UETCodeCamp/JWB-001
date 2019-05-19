package com.jwb.bankservice.services;

import java.util.ArrayList;

import com.jwb.bankservice.models.Customer;
import com.jwb.bankservice.repositories.CustomerList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServices {
    @Autowired
    CustomerList cList;
    private static int id = 0;

    public Customer getCustomer(int id){
        for(Customer c : cList.customerList){
            if (c.getId() == id) return c;
        }
        return null;
    }

    public ArrayList<Customer> getAllCustomer(){
        return cList.customerList;
    }

    public void addCustomer(Customer ctm){
        ctm.setId(id);
        cList.customerList.add(ctm);
        id++;
    }

    public void delCustomerList(int id){
        int n = cList.customerList.size();
        for(int i=0; i<n; i++){
            if (cList.customerList.get(i).getId() == id) {
                cList.customerList.remove(cList.customerList.get(i));
                break;
            }
        }
    }

    public void editCustomer(Customer customer){
        int id = customer.getId();
        Customer c = getCustomer(id);
        c.setName(customer.getName());
        c.setEmail(customer.getEmail());
        c.setPhoneNumber(customer.getPhoneNumber());
        c.setPassword(customer.getPassword());
    }

    public void transferMoney(int sId, int rId, int amount){
        for(Customer c : getAllCustomer()){
            if (c.getId() == rId){
                getCustomer(sId).transferMoney(amount);
                c.receiveMoney(amount);
                break;
            }
        }
    }

    public ArrayList<String> search(String data){
        String result = new String();
        ArrayList<String> listResult = new ArrayList<>();
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