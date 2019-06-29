package com.uetcodecamp.mywalletversion1.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "customer")
@JsonIgnoreProperties("hibernateLazyInitializer")
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long Id;

    @Column(name = "name")
    private String Name;

    @Column(name = "email")
    private String Email;

    @Column(name = "phone")
    private String Phone;

    @Column(name = "balance")
    private long Balance;

    public Customer(Long id, String name, String email, String phone, Long balance) {
        Id = id;
        Name = name;
        Email = email;
        Phone = phone;
        Balance = balance;
    }

//    public Customer(){
//        this.Id = 1;
//        this.Name = "Unknown";
//        this.Email = "Unknown";
//        this.Balance = 0;
//    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public Long getBalance() {
        return Balance;
    }

    public void setBalance(Long balance) {
        Balance = balance;
    }
}
