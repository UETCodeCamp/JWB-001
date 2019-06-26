package com.uetcodecamp.jwb01.controller;

import com.uetcodecamp.jwb01.model.Customer;
import com.uetcodecamp.jwb01.model.CustomerList;
import org.hibernate.usertype.CompositeUserType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping
public class TransfersController {
    public Customer findId(int id){
        for (int i = 0; i < CustomerList.CustomerList.size(); i++){
            if (id == CustomerList.CustomerList.get(i).getId()){
                return CustomerList.CustomerList.get(i);
            }
        }
        return null;
    }

    @PostMapping("Transfers-customer")
    public String Transfers(@RequestParam( "IdCustomerReceive") int IdReceive,
                            @RequestParam("IdCustomerSend") int IdSend,
                            @RequestParam("Money") int money){
        int balanceReceive = CustomerList.CustomerList.get(IdReceive).getBalance();
        int balanceSend = CustomerList.CustomerList.get(IdSend).getBalance();
        if (findId(IdReceive)!= null && findId(IdReceive).getId()!=IdSend){
            CustomerList.CustomerList.get(IdReceive).setBalance(balanceReceive+money);
            CustomerList.CustomerList.get(IdSend).setBalance(balanceSend-money);
        }
        return "redirect:/";
    }
}
