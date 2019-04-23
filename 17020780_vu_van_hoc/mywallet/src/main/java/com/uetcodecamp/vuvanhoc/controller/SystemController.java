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
	private int templateId;

	@RequestMapping(value = {"/"})
	public String index(Model model) {
		model.addAttribute("items", items);
		return "home";
	}
	@GetMapping(value = "/them-nguoi-dung")
	public String formGet(){
		return "themUser";
	}
	@PostMapping(value = "/them-nguoi-dung")
	public String formPost(@RequestParam String name, @RequestParam String email,
	                       @RequestParam String phone, @RequestParam int balance){
		User newUser = new User(name, email, phone, balance);
		newUser.setId(templateId);
		templateId++;
		items.add(newUser);
		return "redirect:/";
	}
	@GetMapping(value = "/sua-thong-tin")
	public String sua(){
		return "suaThongTin";
	}
	@PostMapping(value = "/sua-thong-tin/")
	public String formUpdate(User user, Model model){
		System.out.println();
		return "redirect:/";
	}

}