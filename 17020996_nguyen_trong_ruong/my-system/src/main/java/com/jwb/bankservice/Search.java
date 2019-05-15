package com.jwb.bankservice;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class Search {

    private ArrayList<String> search(String data){
        String result = new String();
        ArrayList<String> listResult = new ArrayList<>();
        for(Customer customer : CustomerList.customerList){
            if (customer.getName().contains(data) || customer.getEmail().contains(data) || customer.getPhoneNumber().contains(data)){
                result += "<tr> <td>" + customer.getName() + "</td> <td>" + customer.getEmail() + "</td> <td>" + customer.getPhoneNumber() + "</td> </tr>";
                listResult.add(result);
                result = "";
            }
        }
        return listResult;
    }

    @PostMapping(value="/search")
    public ArrayList<String> searchCustomer(@RequestBody String data) {
        int n = data.length();
        data = data.substring(1, n-1);
        ArrayList<String> listResult = search(data);
        System.out.println(listResult);
        return listResult;
    }    
}