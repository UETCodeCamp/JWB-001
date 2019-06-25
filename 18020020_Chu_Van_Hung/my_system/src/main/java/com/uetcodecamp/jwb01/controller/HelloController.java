package com.uetcodecamp.jwb01.controller;

import com.uetcodecamp.jwb01.model.User;
import com.uetcodecamp.jwb01.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Controller
public class HelloController {

    private List<User> items = new ArrayList<>();
    private User session;
    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/")
    public String index(Model model) {
        items = userRepository.findAll();
        model.addAttribute("items", items);
        model.addAttribute("session", session);
        return "home";
    }

    @GetMapping("add")
    public String indexAdd()
    {
        return "add";
    }
    @PostMapping("add")
    public String submitFormAdd(@RequestParam("name") String name,
                                @RequestParam("email") String email,
                                @RequestParam("phone") String phone,
                                @RequestParam("balance") int balance) {
        User newUser = new User(name, email, phone, "123456", balance);
        userRepository.save(newUser);
        return "redirect:/";
    }

    @GetMapping("edit/{id}")
    public String indexEdit(@PathVariable("id") Long id,
                            Model model) {
        model.addAttribute("id", id);

        Optional<User> user = userRepository.findById(id);
        if(!user.isPresent()) {
            return "edit";
        }
        model.addAttribute("name", user.get().getName());
        model.addAttribute("email", user.get().getEmail());
        model.addAttribute("phone", user.get().getPhone());
        model.addAttribute("balance", user.get().getBalance());
        return "edit";
    }
    @PostMapping("edit/{id}")
    public String submitEdit(@PathVariable("id") Long id,
                             @RequestParam("email") String email,
                             @RequestParam("name") String name,
                             @RequestParam("phone") String phone,
                             @RequestParam("balance") int balance) {
        Optional<User> user = userRepository.findById(id);
        if(!user.isPresent()) return "redirect:/";
        user.get().editUser(name, email, phone, user.get().getPassword(), balance);
        userRepository.save(user.get());
        return "redirect:/";
    }
    @PostMapping("delete")
    public String indexDelete(@RequestParam("id") Long id,
                              Model model){
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()) userRepository.deleteById(id);
        items = userRepository.findAll();
        model.addAttribute("items", items);
        return  "list";
    }
    @RequestMapping("list")
    public String indexList(Model model)
    {
        items = userRepository.findAll();
        model.addAttribute("items", items);
        return "list";
    }
    @PostMapping("search")
    public String indexSearch(@RequestParam("name") String name,
                              Model model){
        List<Integer> lstSearch = new ArrayList<>();
        items = userRepository.findAll();
        for(int i = 0; i < items.size(); i++)
        {
            if(items.get(i).getName().equals(name) || items.get(i).getEmail().equals(name) || items.get(i).getPhone().equals(name)) lstSearch.add(i);
        }
        model.addAttribute("items", items);
        model.addAttribute("lstSearch", lstSearch);
        return "search";
    }

    @GetMapping("login")
    public String indexLogin()
    {
        if(session != null) return "redirect:/profile";
        return "login";
    }
    @PostMapping("login")
    public String submitLogin(@RequestParam("email") String email,
                              @RequestParam("password") String password,
                              Model resLogin) {
        List<User> user = userRepository.findByEmail(email);
        for(int i = 0; i < user.size(); i++)
            if(user.get(i).isLogin(email, password)) {
                session = user.get(i);
                return "redirect:/profile";
            }

        resLogin.addAttribute("messLogin", "Đăng nhập không thành công!");
        return "login";
    }

    @RequestMapping("logout")
    public String indexLogout()
    {
        session = null;
        return "redirect:/";
    }

    @RequestMapping("profile")
    public String indexProfile(Model model)
    {
        model.addAttribute("session", session);
        return "profile";
    }

    @GetMapping("transfer")
    public String indexTranfer()
    {
        return "transfer";
    }

    @PostMapping("transfer")
    public String submitTranfer(@RequestParam("id") Long id,
                              @RequestParam("balance") int balance,
                              Model resTransfer) {
        Optional<User> user = userRepository.findById(id);
        int myBalance = session.getBalance();
        if(user.isPresent() && user.get().getId() == session.getId()) return "redirect:/profile";
        if(user.isPresent() && myBalance - balance >= 0 && balance >= 0){
            session.setBalance(myBalance - balance);
            userRepository.save(session);
            user.get().setBalance(user.get().getBalance() + balance);
            userRepository.save(user.get());
            return "redirect:/profile";
        }
        else if(myBalance - balance < 0){
            resTransfer.addAttribute("messTransfer", "LỖI: Số dư trong tài khoản không đủ!");
            return "transfer";
        }
        else if(balance < 0){
            resTransfer.addAttribute("messTransfer", "LỖI: Số tiền chuyển không hợp lệ!");
            return "transfer";
        }
        else {
            resTransfer.addAttribute("messTransfer", "LỖI: ID không tồn tại!");
            return "transfer";
        }
    }
}