package com.uetcodecamp.jwb01.controller;

import com.uetcodecamp.jwb01.model.User;
import com.uetcodecamp.jwb01.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Controller
public class HelloController {


    @Autowired
    private UserController userController;

    @RequestMapping("/")
    public String index(Model model, HttpSession session) {
        List<User> items = userController.GetAllUser();
        model.addAttribute("items", items);
        model.addAttribute("session", session.getAttribute("user"));
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
                                @RequestParam("password") String password,
                                @RequestParam("phone") String phone,
                                @RequestParam("balance") Long balance,
                                Model model) {
        List<User> user = userController.GetUserByEmail(email);
        if(user.size() > 0) {
            model.addAttribute("messAdd", "Đăng kí không thành công!");
            return "add";
        }
        User newUser = new User(name, email, phone, password, balance);
        userController.AddNewUser(newUser);
        return "redirect:/";
    }

    @GetMapping("edit/{id}")
    public String indexEdit(@PathVariable("id") Long id,
                            Model model) {
        model.addAttribute("id", id);

        User user = userController.GetUserById(id);
        if(user == null) {
            return "edit";
        }
        model.addAttribute("name", user.getName());
        model.addAttribute("email", user.getEmail());
        model.addAttribute("password", user.getPassword());
        model.addAttribute("phone", user.getPhone());
        model.addAttribute("balance", user.getBalance());
        return "edit";
    }
    @PostMapping("edit/{id}")
    public String submitEdit(@PathVariable("id") Long id,
                             @RequestParam("email") String email,
                             @RequestParam("name") String name,
                             @RequestParam("phone") String phone,
                             @RequestParam("password") String password,
                             @RequestParam("balance") Long balance) {
        User user = userController.GetUserById(id);
        if(user == null) {
            return "redirect:/";
        }
        user.editUser(name, email, phone, password, balance);
        userController.EditUser(user);
        return "redirect:/";
    }
    @PostMapping("delete")
    public String indexDelete(@RequestParam("id") Long id,
                              Model model){
        userController.DeleteUser(id);
        List<User> items = userController.GetAllUser();
        model.addAttribute("items", items);
        return  "list";
    }
    @RequestMapping("list")
    public String indexList(Model model)
    {
        List<User> items = userController.GetAllUser();
        model.addAttribute("items", items);
        return "list";
    }
    @PostMapping("search")
    public String indexSearch(@RequestParam("name") String name,
                              Model model){

        List<User> items = userController.SearchUser(name);
        model.addAttribute("items", items);
        return "search";
    }

    @GetMapping("login")
    public String indexLogin(HttpSession session)
    {

        if(session.getAttribute("user") != null) return "redirect:/";
        return "login";
    }
    @PostMapping("login")
    public String submitLogin(@RequestParam("email") String email,
                              @RequestParam("password") String password,
                              Model resLogin,
                              HttpSession session) {
        User user = userController.CheckLogin(email, password);
        if(user != null){
            session.setAttribute("user", user);
            return "redirect:/";
        }
        resLogin.addAttribute("messLogin", "Đăng nhập không thành công!");
        return "login";
    }

    @RequestMapping("logout")
    public String indexLogout(HttpSession session)
    {
        session.removeAttribute("user");
        return "redirect:/";
    }

    @RequestMapping("profile")
    public String indexProfile(Model model, HttpSession session)
    {
        model.addAttribute("session", session.getAttribute("user"));
        return "profile";
    }

    @GetMapping("transfer")
    public String indexTranfer(HttpSession session)
    {
        if(session.getAttribute("user") != null) return "transfer";
        else return "redirect:/";
    }

    @PostMapping("transfer")
    public String submitTranfer(@RequestParam("id") Long id,
                              @RequestParam("balance") Long balance,
                              Model resTransfer,
                                HttpSession session) {
        User user = (User)session.getAttribute("user");
        if(user == null){
            resTransfer.addAttribute("messTransfer", "LỖI: Giao dịch không thành công!");
            return "transfer";
        }
        boolean isTransfer = userController.Transfer(user.getId(), id, balance);
        if(isTransfer) {
            session.setAttribute("user", userController.GetUserById(user.getId()));
            return "redirect:/";
        }
        else {
            resTransfer.addAttribute("messTransfer", "LỖI: Giao dịch không thành công!");
            return "transfer";
        }
    }
}