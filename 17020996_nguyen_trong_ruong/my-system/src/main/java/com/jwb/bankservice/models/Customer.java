package com.jwb.bankservice.models;

import javax.persistence.*;

@Entity
@Table(name = "Customer")
public class Customer {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phoneNumber;

    @Column(name = "password")
    private String password = "123456";

    @Column(name = "balance")
    private int balance;

    @Column(name = "login")
    private int login = 1;
    
    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getLogin(){
        return login;
    }

    public void setLogin(int isLogin){
        this.login = isLogin;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String newPw){
        this.password = newPw;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void transferMoney(int amount){
        balance -= amount;
    }

    public void receiveMoney(int amount){
        balance += amount;
    }
}