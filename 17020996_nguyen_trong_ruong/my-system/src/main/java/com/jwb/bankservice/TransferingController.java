package com.jwb.bankservice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TransferingController {
    @PostMapping(value="/transfer")
    public String transfer(@RequestParam(name = "sentId") Integer sId, @RequestParam(name="receivedId") Integer rId, @RequestParam(name="amount") Integer amount){
        if (rId == sId) return "Error";
        System.out.println(rId);
        int n = CustomerList.customerList.size();
        for(int i=0; i<n; i++){
            if (rId == CustomerList.customerList.get(i).getId()){
                CustomerList.customerList.get(sId).transferMoney(amount);
                CustomerList.customerList.get(rId).receiveMoney(amount);
                return "redirect:/customer-list";
            }
        }
        return "Error";
    }
}