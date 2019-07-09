package com.CodeCamp2019.controller;

import com.CodeCamp2019.model.Customer;
import com.CodeCamp2019.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;



@Controller
public class CustomerController {


    @Autowired
    CustomerService customerService;

    @RequestMapping("/")
    public String index(Model model) {
        List<Customer> customerList = customerService.findAll();
        model.addAttribute("customerList", customerList);
        return "home";
    }

    @GetMapping(value = "/insert")
    public String insert() {
        return "insert";
    }


    @PostMapping(value = "/add")
    public String addName(@RequestParam(value = "id"/*, required = false*/) int id,
                          @RequestParam(value = "fullname") String name,
                          @RequestParam(value = "email") String email,
                          @RequestParam(value = "phone") String phone,
                          @RequestParam(value = "balance") int balance
                          ) {
        Customer cus1 = new Customer(id, name, email, phone, balance);
        customerService.save(cus1);
        return "redirect:/";
    }

    @RequestMapping(value = "/replace")
    public String replace(@RequestParam(value = "customerId") int id, Model model) {

        //model.addAttribute("customerId",id);
        model.addAttribute("customer1", customerService.getOne(id));
        return "replace";
    }

    @PostMapping(value = "/replaceCus")
    public String replaceCustomer(@RequestParam(value = "id") int id,
                                  @RequestParam(value = "name") String name,
                                  @RequestParam(value = "email") String email,
                                  @RequestParam(value = "phone") String phone,
                                  @RequestParam(value = "balance") int balance
    ){
        Customer customer = new Customer(id,name,email,phone,balance);
        customerService.save(customer);
        return "redirect:/";
    }

//-----------------------------------------------------------
    @RequestMapping(value = "/login")
    public String login(){
        return "login";
    }
    @PostMapping(value = "/login")
    public String Login(@RequestParam(value = "username") String user,
                        @RequestParam(value = "password") String pass,
                        Model model
                        ){
        List<Customer> customerList = customerService.findAll();
        for (Customer customer :customerList){
            if(customer.getEmail().equals(user) && pass.equals("123456")){

                model.addAttribute("customer",customer);
                return "inforUser";
            }

        }
        model.addAttribute("customer",new Customer());
        return "loginFail";

    }

//---------------------------------------------------------
    @RequestMapping(value = "transfer")
    public String transfer(@RequestParam(value = "transferFrom") int id, Model model){

        model.addAttribute("id",id);
        return "transfer";
    }
    @PostMapping(value = "transferToID")
    public String transferToID(@RequestParam(value = "fromId") int fromid,
                                @RequestParam(value = "id") int id,
                               @RequestParam(value = "amount") int amount
                               ){
        if(customerService.getOne(fromid).getBalance() >= amount ) {
            Customer fromCustomer = customerService.getOne(fromid);
            Customer toCustomer = customerService.getOne(id);

            fromCustomer.setBalance(fromCustomer.getBalance() - amount);
            toCustomer.setBalance(toCustomer.getBalance() + amount);

            customerService.save(fromCustomer);
            customerService.save(toCustomer);

            return "redirect:/";
        }
        return "errorTransfer";

    }
    //------------------
    @RequestMapping(value = "delete")
    public String removeCus(@RequestParam(value = "deleteID") int id, Model model){
        Customer customer = customerService.getOne(id);
        model.addAttribute("deleteCustomer",customer);
        return "deleteCustomer";
    }
    @PostMapping(value = "/deleteCustomer")
    public String deleteCustomer(@RequestParam(value = "id") int id){
        customerService.deleteCustomer(id);
        return "redirect:/";
    }
    @PostMapping("/cancel")
    public String cancelDelete(){
        return "redirect:/";
    }

    //-------------------------------------------------
    @GetMapping(value = "search")
    public String search(@RequestParam(value = "information") String infor,
                         Model model){
        List<Customer> customers = customerService.search(infor);
        if(customers.size() != 0 ){
            model.addAttribute("customerList", customers);
            return "home";
        }
        return "notFound";
    }

}