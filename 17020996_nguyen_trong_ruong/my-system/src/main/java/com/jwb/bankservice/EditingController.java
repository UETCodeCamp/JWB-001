package com.jwb.bankservice;

import com.jwb.bankservice.models.Customer;
import com.jwb.bankservice.services.CustomerServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EditingController {
    @Autowired
    CustomerServices cServices;

    @PostMapping(value="/edit-customer")
    public String addCustomer(@ModelAttribute("customerInfo") Customer customer) {
        cServices.editCustomer(customer);
        return "redirect:/customer-list";
    }
}