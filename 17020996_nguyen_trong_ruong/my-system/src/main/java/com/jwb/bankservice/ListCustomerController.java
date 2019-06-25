package com.jwb.bankservice;

import com.jwb.bankservice.models.Customer;
import com.jwb.bankservice.services.CustomerServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ListCustomerController {
    @Autowired
    CustomerServices cServices;

    @GetMapping(value = {"/", "/customer-list" })
    public String index(ModelMap modelMap) {
        modelMap.addAttribute("customerList", cServices.getAllCustomer());
        return "CustomerList";
    }

    @GetMapping(value="/editing-form")
    public String editForm(@RequestParam(name="customerId") Integer id, ModelMap modelMap) {
        Customer c = cServices.getCustomer(id);
        modelMap.addAttribute("customerInfo", c);
        return "Edit";
    }

    @GetMapping(value = { "/adding-form" })
    public String addForm(ModelMap modelmap) {
        return "Add";
    }
}