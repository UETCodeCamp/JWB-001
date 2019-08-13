package com.uetcodecamp.jwb01.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "user")
@JsonIgnoreProperties("hibernateLazyInitializer")
// Serializable, Jackson (ignore properties)

public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "password")
    private String password;

    @Column(name = "balance")
    private Long balance;

    public User()
    {
        this.password = "123456";
    }

    public User(String name, String email, String phone, String password, Long balance)
    {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.balance = balance;
        this.password = password;
    }

    public void editUser(String name, String email, String phone, String password, Long balance)
    {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.balance = balance;
        this.password = password;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public Long getBalance() {
        return balance;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public Boolean isLogin( String email, String password)
    {
        return (email.equals(this.email) && password.equals(this.password));
    }
}

