package com.uetcodecamp.vuvanhoc.controller;

import com.uetcodecamp.vuvanhoc.objects.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.View;

import java.util.ArrayList;

@Controller
public class SystemController {

	ArrayList<User> items = new ArrayList<>();

	@RequestMapping(value = {"/", "/home"})
	public String index(Model model) {
		model.addAttribute("items", items);
		return "home";
	}

	@GetMapping(value = "/add")
	public String add(Model model, @RequestParam String name, @RequestParam String phone,
	                  @RequestParam String email, @RequestParam int balance) {
		model.addAttribute("items", items);
		items.add(new User(name, phone, email, balance));

		return "add";
	}


}