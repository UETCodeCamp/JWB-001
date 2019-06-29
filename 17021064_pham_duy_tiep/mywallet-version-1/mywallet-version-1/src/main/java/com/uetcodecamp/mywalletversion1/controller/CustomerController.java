package com.uetcodecamp.mywalletversion1.controller;

import com.uetcodecamp.mywalletversion1.model.Customer;
import com.uetcodecamp.mywalletversion1.repository.CustomerRepository;
import com.uetcodecamp.mywalletversion1.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;


    @GetMapping(value = {"/", "Customer/list"})
    public String viewCustomerList(ModelMap modelMap) {
        modelMap.addAttribute("CustomerList", customerService.getAllCustomer());
        return "CustomerList";
    }

    @GetMapping(value = "Customer/add")
    public String addGet(ModelMap modelmap) {
        modelmap.addAttribute("customerAdd", new Customer());
        return "AddCustomer";
    }

    @PostMapping(value = "Customer/add")
    public String addPost(@ModelAttribute("customerAdd") Customer customer){
        customerService.addCustomer(customer);
        return "redirect:/";
    }

    @GetMapping(value = "/Customer/delete")
    public String Delete(@RequestParam("CustomerId") Long id){
        Customer customer = customerService.getOne(id);
        if (customer == null) {

        }
        customerService.delete(customer);
        return "redirect:/";
    }

    @GetMapping(value = "/Customer/edit")
    public String EditGet(@RequestParam("CustomerId") Long id, ModelMap modelMap){
        modelMap.addAttribute("CustomerEdit", customerService.getOne(id));
        System.out.println("Name: " + customerService.getOne(id).getName());
        return "EditCustomer";
    }

    @PostMapping(value = "/Customer/edit")
    public String EditPost(@ModelAttribute("CustomerEdit") Customer customer){
        customerService.updateCustomer(customerService.getOne(customer.getId()), customer);
        System.out.println("Name:" + customer.getName() + ", Id: " + customer.getId( ));
        return "redirect:/";
    }

    @GetMapping(value = "/Customer/login")
    public String loginGet(ModelMap modelMap){
        modelMap.addAttribute("customerLogin", new Customer());
        return "Login";
    }

    @PostMapping(value = "/Customer/login")
    public String loginPost(@ModelAttribute("customerLogin") Customer customer, ModelMap modelMap){
        Customer customerLogin = customerService.checkLogin(customer.getEmail(), customer.getPassword());
        if (customerLogin == null){
            return "Login";
        }
        modelMap.addAttribute("Customer", customerLogin);
        return "Profile";
    }

    @GetMapping(value = "Customer/transfer")
    public String transfer(@RequestParam("CustomerId") Long id, Model model){
        model.addAttribute("CustomerId", id);
        return "Transfer";
    }

    @PostMapping("Customer/transfer")
    public String Transfers(@RequestParam( "IdCustomerReceive") Long IdReceive,
                            @RequestParam("IdCustomerSend") Long IdSend,
                            @RequestParam("Money") int money){
        Customer customerReceive = customerService.getOne(IdReceive);
        Customer customerSend = customerService.getOne(IdSend);

        if (customerReceive != null){
            customerReceive.setBalance(customerReceive.getBalance() + money);
            customerSend.setBalance(customerSend.getBalance() - money);
            customerService.updateCustomer(customerService.getOne(IdReceive), customerReceive);
            customerService.updateCustomer(customerService.getOne(IdSend), customerSend);
            return "redirect:/";
        }
        return "redirect:/Tranfer";
    }

}
