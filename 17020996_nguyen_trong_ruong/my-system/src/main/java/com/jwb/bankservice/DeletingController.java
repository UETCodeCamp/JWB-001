package com.jwb.bankservice;

import com.jwb.bankservice.services.CustomerServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class DeletingController {
    @Autowired
    CustomerServices cServices;

    @PostMapping(value="/delete")
    public void delCustomer(@RequestBody String delId) {
        delId = delId.substring(3,delId.length());
        int id = Integer.parseInt(delId);
        cServices.delCustomerList(id);
    }  
}