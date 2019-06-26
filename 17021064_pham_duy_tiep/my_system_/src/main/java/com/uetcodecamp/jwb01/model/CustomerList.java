package com.uetcodecamp.jwb01.model;

import java.util.ArrayList;

public class CustomerList {
    public static ArrayList<Customer> CustomerList = new ArrayList<>();
    static {
        CustomerList.add(new Customer(0,"Nguyen Van A", "A@mail.com", "1900", 10000,"123456"));
        CustomerList.add(new Customer(1,"Nguyen Van B", "B@mail.com", "1800", 20000,"123456"));
        CustomerList.add(new Customer(2,"Nguyen Van C", "C@mail.com", "1700", 30000,"123456"));
    }
}
