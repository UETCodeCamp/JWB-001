package com.jwb.bankservice;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class DeletingController {
    @PostMapping(value="/delete")
    public void delCustomer(@RequestBody String delId) {
        delId = delId.substring(3,delId.length());
        int id = Integer.parseInt(delId);
        CustomerList.delCustomerList(id);
    }  
}