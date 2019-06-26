package com.uetcodecamp.jwb01.controller;

import com.uetcodecamp.jwb01.model.Customer;
import com.uetcodecamp.jwb01.model.CustomerList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping
public class LoginCustomer {
    public Customer findCustomer(String email, String password){
        System.out.println("email: " + email + ", pass: " + password);
        for (int i = 0; i < CustomerList.CustomerList.size(); i++){
            String tmpEmail = CustomerList.CustomerList.get(i).getEmail();
            //System.out.println(tmpEmail);
            String tmpPass = CustomerList.CustomerList.get(i).getPassword();
            //System.out.println(tmpPass);
            if (tmpEmail.equals(email) && tmpPass.equals(password)){
                //System.out.println("Tìm thấy customer: " + tmpEmail + ", " + tmpPass );
                return CustomerList.CustomerList.get(i);
            }
            //System.out.println("not found");
        }
        return null;
    }

    @PostMapping(value = "Login-customer")
    public String Login(@ModelAttribute("customerLogin") Customer customerLogin, ModelMap modelMap) {
        //System.out.println(customerLogin.getEmail());
        Customer customer = findCustomer(customerLogin.getEmail(), customerLogin.getPassword());
        if (customer != null){
            modelMap.addAttribute("Customer", customer);
            return "Profile";
        }
        return "Login";
    }
}
