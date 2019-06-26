package com.uetcodecamp.jwb01.controller;

import com.uetcodecamp.jwb01.model.Customer;
import com.uetcodecamp.jwb01.model.CustomerList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class AddCutomer{
    @PostMapping(value="Add-customer")
    public String add(@ModelAttribute("CustomerAdd") Customer CustomerAdd) {
        CustomerAdd.setId(CustomerList.CustomerList.size());
        CustomerList.CustomerList.add(CustomerAdd);
        return "redirect:/";
    }
}
