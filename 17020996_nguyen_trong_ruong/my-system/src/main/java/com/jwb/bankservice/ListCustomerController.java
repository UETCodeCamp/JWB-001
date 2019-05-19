package com.jwb.bankservice;

import com.jwb.bankservice.models.Customer;
import com.jwb.bankservice.services.CustomerServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ListCustomerController {
    @Autowired
    CustomerServices cServices;

    @RequestMapping(value = {"/", "/customer-list" }, method = RequestMethod.GET)
    public String index(ModelMap modelMap) {
        modelMap.addAttribute("customerList", cServices.getAllCustomer());
        return "CustomerList";
    }

    @RequestMapping(value = { "/adding-form" }, method = RequestMethod.GET)
    public String addForm(ModelMap modelmap) {
        modelmap.addAttribute("customerInfo", new Customer());
        return "Add";
    }
    @GetMapping(value="/editing-form")
    public String editForm(@RequestParam(name="customerId") Integer id, ModelMap modelMap) {
        modelMap.addAttribute("customerInfo", cServices.getCustomer(id));
        return "Edit";
    }
    @GetMapping(value="/login-form")
    public String loginForm(@RequestParam(name="customerId") Integer id, ModelMap modelMap){
        modelMap.addAttribute("customerInfo", cServices.getCustomer(id));
        return "Login";
    }
    @PostMapping(value="/transfering-form")
    public String transferingForm(@RequestParam(name="customerId") Integer id, @RequestParam(name="availableBalance") Integer balance, ModelMap modelMap){
        modelMap.addAttribute("customerId", id);
        modelMap.addAttribute("balance", balance);
        return "Transfer";
    }
}