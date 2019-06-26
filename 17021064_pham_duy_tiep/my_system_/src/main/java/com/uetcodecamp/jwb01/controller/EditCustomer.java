package com.uetcodecamp.jwb01.controller;

import com.uetcodecamp.jwb01.model.Customer;
import com.uetcodecamp.jwb01.model.CustomerList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EditCustomer {

    @PostMapping(value = "Edit-customer")
    public String Edit(@ModelAttribute("CustomerEdit") Customer CustomerEdit) {
        //System.out.println(CustomerEdit.getName() + " " + CustomerEdit.getId());
        int Id = CustomerEdit.getId();
        //System.out.println(Id);
        String newName = CustomerEdit.getName();
        CustomerList.CustomerList.get(Id).setName(newName);
        String newEmail = CustomerEdit.getEmail();
        CustomerList.CustomerList.get(Id).setEmail(newEmail);
        String newPhone = CustomerEdit.getPhone();
        CustomerList.CustomerList.get(Id).setPhone(newPhone);
        return "redirect:/";
    }
}
