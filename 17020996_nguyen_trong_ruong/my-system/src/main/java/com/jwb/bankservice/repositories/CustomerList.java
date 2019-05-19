package com.jwb.bankservice.repositories;

import java.util.ArrayList;
import com.jwb.bankservice.models.Customer;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerList {
    public ArrayList<Customer> customerList = new ArrayList<Customer>();
    // private static int id = 0;

    // public static void addCustomer(Customer ctm){
    //     ctm.setId(id);
    //     customerList.add(ctm);
    //     id++;
    // }

    // public static void delCustomerList(int id){
    //     int n = customerList.size();
    //     for(int i=0; i<n; i++){
    //         if (customerList.get(i).getId() == id) {
    //             customerList.remove(customerList.get(i));
    //             break;
    //         }
    //     }
    // }

    // static{
    //     addCustomer(new Customer("abc", "abc@mail.com", "12345", 100));
    //     addCustomer(new Customer("abcabc", "abcabc@mail.com", "54321", 100));
    //     addCustomer(new Customer("xyz", "xyz@mail.com", "58835", 100));
    //     addCustomer(new Customer("jqk", "jqk@mail.com", "72382", 100));
    // }
}