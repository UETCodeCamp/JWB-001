package com.uetcodecamp.mywalletversion1.controller;

import com.uetcodecamp.mywalletversion1.model.Customer;
import com.uetcodecamp.mywalletversion1.repository.CustomerRepository;
import com.uetcodecamp.mywalletversion1.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;


    @GetMapping(value = {"/", "Customer-list"})
    public String viewCustomerList(ModelMap modelMap) {
        modelMap.addAttribute("customer", customerService.getAllCustomer());
        return "CustomerList";
    }
}
