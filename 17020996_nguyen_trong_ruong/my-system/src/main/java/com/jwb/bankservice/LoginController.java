package com.jwb.bankservice;

import com.jwb.bankservice.services.CustomerServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @Autowired
    CustomerServices cServices;

    @GetMapping(value="/login-form")
    public String loginForm(@RequestParam(name="customerId") Integer id, ModelMap modelMap){
        modelMap.addAttribute("customerInfo", cServices.getCustomer(id));
        return "Login";
    }

    @PostMapping(value="/login")
    public String addCustomer(@RequestParam(name="id") Integer id, @RequestParam(name="pw") String password) {
        if (cServices.login(id, password)){
            return "redirect:/customer-list";
        }
        return "Error";
    }
}