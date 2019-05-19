package com.jwb.bankservice;

import com.jwb.bankservice.services.CustomerServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LogoutController {
    @Autowired
    CustomerServices cServices;

    @GetMapping(value="/logout")
    public String logout(@RequestParam(name="customerId") Integer id){
        cServices.getCustomer(id).setLogin(0);
        return "redirect:/customer-list";
    }
}