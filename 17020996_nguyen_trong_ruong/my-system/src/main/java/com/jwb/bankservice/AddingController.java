package com.jwb.bankservice;

import com.jwb.bankservice.models.Customer;
import com.jwb.bankservice.services.CustomerServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AddingController {
    @Autowired
    CustomerServices cServices;

    @PostMapping(value="/add-customer")
    public String addCustomer(@ModelAttribute("customerInfo") Customer customer) {
        cServices.addCustomer(customer);
        return "redirect:/customer-list";
    }
}