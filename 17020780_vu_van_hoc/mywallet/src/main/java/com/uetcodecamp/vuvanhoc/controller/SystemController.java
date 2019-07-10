package com.uetcodecamp.vuvanhoc.controller;

import com.uetcodecamp.vuvanhoc.model.Customer;
import com.uetcodecamp.vuvanhoc.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

@Controller
public class SystemController {

	@Autowired
	CustomerService customerService;

	@RequestMapping(value = {"/"})
	public String home(Model model) {
		List<Customer> customerList = customerService.getAllCustomer();
		model.addAttribute("customerList", customerList);
		return "home";
	}
	@GetMapping(value = "/them-nguoi-dung")
	public String pageFormAddUser(){
		return "pageAddUser";
	}
	@PostMapping(value = "/xu-ly-them-nguoi-dung")
	public String handleFormAddUser(@RequestParam("name") String name, @RequestParam("email") String email,
	                       @RequestParam("phone") String phone, @RequestParam("balance") double balance){
		customerService.addNewUser(new Customer(name, email, phone, balance));
		return "redirect:/";
	}
	@GetMapping(value = "/sua-thong-tin")
	public String pageFormEditUserInfor(@RequestParam("id") int id, Model model){
		Customer customer = customerService.getCustomerById(id);
		model.addAttribute("customer", customer);
		System.out.println("Sua id " + id);
		return "pageEditUserInfor";
	}

	@DeleteMapping(value = "/xoa-nguoi-dung")
	public String deleteUser(@RequestParam("id") int id ){
		System.out.println("Remove id " +id);
		customerService.deleteUserById(id);
		return "redirect:/";
	}

//	@PostMapping(value = "/xu-li-form-sua-thong-tin/{key}")
//	public String formUpdatePost( @PathVariable("key") int key,@RequestParam String name,
//	                              @RequestParam String email, @RequestParam String phone,
//	                              @RequestParam int balance){
//
//		customerList.get(key).setName(name);
//		customerList.get(key).setPhone(phone);
//		customerList.get(key).setEmail(email);
//		customerList.get(key).setBalance(balance);
//		return "redirect:/";
//	}
	@GetMapping(value = "/dang-nhap")
	public String pageFormLogin(){
		return "pageLogin";
	}
	@GetMapping(value = "/thong-tin-nguoi-dung/{id}")
	public String formLoginPost(@PathVariable("id") int id, Model model){
		Customer customer = customerService.getCustomerById(id);
		model.addAttribute("customer", customer);
		return "pageInforUser";
	}
//	@PostMapping(value = "/xu-li-dang-nhap")
//	public String xuLiDangNhap(@RequestParam String email, @RequestParam String password){
//		String defaultPassword = "123456";
//		for(int i : customerList.keySet()){
//			if(customerList.get(i).getEmail().equals(email) && password.equals(defaultPassword)){
//				System.out.println("dang nhap thanh cong");
//				return "redirect:/thong-tin-nguoi-dung/" + i;
//			}
//		}
////		System.out.println("dang nhap sai roi");
//		return "thongBao/error";
//	}
//	@PostMapping(value = "/giao-dich/{key}")
//	public String chuyenTien(@PathVariable("key") int key, Model model){
//		model.addAttribute(key);
//		return "pageTransferMoney";
//	}
//	@PostMapping(value = "/xu-li-giao-dich/{key}")
//	public String xuLiGiaoDich(@PathVariable("key") int key,
//	                           @RequestParam int id, @RequestParam int amount) {
//		final int soDuToiThieu = 50000;
//		if (customerList.get(key).getBalance() - amount < soDuToiThieu) {
//			System.out.println("chuyen tien that bai");
//			return "thongBao/loiGiaoDich";
//		} else {
//			for (int i : customerList.keySet()) {
//				if (customerList.get(i).getId() == id) {
//					customerList.get(i).setBalance(customerList.get(i).getBalance() + amount);
//					customerList.get(key).setBalance(customerList.get(key).getBalance() - amount);
//					return "redirect:/";
//				}
//			}
//		}
//		return "thongBao/idNotFound";
//	}
//

}