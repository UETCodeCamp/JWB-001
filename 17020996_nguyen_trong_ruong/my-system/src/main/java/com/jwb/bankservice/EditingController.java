package com.jwb.bankservice;

import com.jwb.bankservice.models.Customer;
import com.jwb.bankservice.services.CustomerServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EditingController {
    @Autowired
    CustomerServices cServices;

    @PostMapping(value="/edit-customer")
    public String addCustomer(@RequestBody Customer customer) {
        cServices.editCustomer(customer);
        return "/";
    }
}