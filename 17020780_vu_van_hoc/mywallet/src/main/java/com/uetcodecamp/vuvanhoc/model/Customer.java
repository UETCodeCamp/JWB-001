package com.uetcodecamp.vuvanhoc.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@Column(name = "cus_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id ;

	@Column(name = "cus_name")
	private String name;

	@Column(name = "cus_email")
	private String email;

	@Column(name = "cus_phone")
	private String phone;

	@Column(name = "cus_balance")
	private Double balance;


	public Customer(String name, String email, String phone, Double balance) {
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.balance = balance;

	}

	public Customer() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}


}
