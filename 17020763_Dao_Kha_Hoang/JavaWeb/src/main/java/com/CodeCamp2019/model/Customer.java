package com.CodeCamp2019.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "Customer")
@JsonIgnoreProperties("hibernateLazyInitializer")
public class Customer {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;
    @Column(name = "balance")
    private int balance;
    public  Customer(){
        this.id = -1;
        this.name = "";
        this.email = "";
        this.phone = "";
        this.balance = 0;
    }
    public Customer(Customer cu1){
        this.id = cu1.id;
        this.name = cu1.name;
        this.email = cu1.email;
        this.phone = cu1.phone;
        this.balance = cu1.balance;
    }
    public Customer(int id, String name, String email, String phone, int balance){
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.balance = balance;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public String getEmail(){
        return this.email;
    }
    public String getPhone(){
        return this.phone;
    }
    public int getBalance(){
        return this.balance;
    }

    public boolean isNull(){
        if(this.id != -1) return false;
        return true;
    }
    /*

    create table Customer(
     id int(5) not null auto_increment,
     name varchar(50) not null,
     email varchar(50) not null,
     phone varchar(11) not null,
     balance int(50) not null,
     primary key (id)
     ) engine=InnoDB Auto_increment=1 default charset=utf8;
     */
}
