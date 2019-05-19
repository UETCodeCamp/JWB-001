package com.jwb.bankservice;

import com.jwb.bankservice.services.CustomerServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @Autowired
    CustomerServices cServices;

    @PostMapping(value="/login")
    public String addCustomer(@RequestParam(name="id") Integer id, @RequestParam(name="pw") String password) {
        if (cServices.getCustomer(id).getPassword().equals(password)){
            cServices.getCustomer(id).setLogin(1);
        }
        return "redirect:/customer-list";
    }
}