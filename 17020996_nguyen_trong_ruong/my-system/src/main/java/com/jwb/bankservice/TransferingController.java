package com.jwb.bankservice;

import com.jwb.bankservice.services.CustomerServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TransferingController {
    @Autowired
    CustomerServices cServices;

    @PostMapping(value="/transfering-form")
    public String transferingForm(@RequestParam(name="customerId") Integer id, @RequestParam(name="availableBalance") Integer balance, ModelMap modelMap){
        modelMap.addAttribute("customerId", id);
        modelMap.addAttribute("balance", balance);
        return "Transfer";
    }

    @PostMapping(value="/transfer")
    public String transfer(@RequestParam(name = "sentId") Integer sId, @RequestParam(name="receivedId") Integer rId, @RequestParam(name="amount") Integer amount){
        if (rId == sId) return "Error";
        if (amount > cServices.getCustomer(sId).getBalance()) return "Error";
        cServices.transferMoney(sId, rId, amount);
        return "redirect:/";
    }
}