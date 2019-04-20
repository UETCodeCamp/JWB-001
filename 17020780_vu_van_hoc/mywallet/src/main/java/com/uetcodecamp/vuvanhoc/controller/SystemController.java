package com.uetcodecamp.vuvanhoc.controller;

import com.uetcodecamp.vuvanhoc.objects.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class SystemController {

	ArrayList<User> items = new ArrayList<>();
	private int id;

	@RequestMapping(value = {"/", "/home"})
	public String index(Model model) {
		model.addAttribute("items", items);
		return "home";
	}

	@GetMapping(value = "/add")
	public String add(){
		return "add";
	}
	@GetMapping(value = "/addUser2List")
	public String addUser2List(@RequestParam String name, @RequestParam String email,
	                     @RequestParam String phone, @RequestParam int balance) {
		User newUser = new User(name, email, phone, balance);
		id++;
		newUser.setId(id);
		items.add(newUser);
		return "redirect:home";
	}


}