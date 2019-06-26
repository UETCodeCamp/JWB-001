package com.uetcodecamp.jwb01.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.uetcodecamp.jwb01.model.Customer;
import com.uetcodecamp.jwb01.model.CustomerList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


@Controller
public class MainController {
   // static int editId = 0;
    //static int loginId = 0;

    @GetMapping(value = {"CustomerList","/"})
    public String viewCustomerList(ModelMap model) {
        model.addAttribute("CustomerList", CustomerList.CustomerList);
        return "CustomerList";
    }

    @GetMapping(value = {"Add-customer"})
    public String formAdd(ModelMap modelmap) {
        modelmap.addAttribute("CustomerAdd", new Customer());
        return "Addcus";
    }
    @GetMapping(value="Edit-customer")
    public String formEdit(@RequestParam("CustomerId") int id, ModelMap model) {
        model.addAttribute("CustomerEdit", CustomerList.CustomerList.get(id));
        //System.out.println("Name" + CustomerList.CustomerList.get(id).getName());
        //editId = id;
        return "Editcus";
    }

    @GetMapping("Login-customer")
    public String formLogin(ModelMap modelMap){
        modelMap.addAttribute("customerLogin", new Customer());
        return "Login";
    }

    @GetMapping(value = "Delete-customer")
    public String formDelete(@RequestParam("CustomerId") int id ){
        CustomerList.CustomerList.remove(CustomerList.CustomerList.get(id));
        System.out.println("Xoa: " + "Id " +id + "Size la: " + CustomerList.CustomerList.size());
        return "redirect:/";
    }

    @GetMapping(value = "Transfer-customer")
    public String formTransfer(@RequestParam("CustomerId") int id, ModelMap modelMap){
        modelMap.addAttribute("CustomerId", id);
        System.out.println(id);
        return "Transfers";
    }
}
