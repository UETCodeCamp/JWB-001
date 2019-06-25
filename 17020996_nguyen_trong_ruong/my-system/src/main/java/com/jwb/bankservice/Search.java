package com.jwb.bankservice;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.jwb.bankservice.services.CustomerServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class Search {
    @Autowired
    CustomerServices cServices;

    @PostMapping(value="/search")
    public List<String> searchCustomer(@RequestBody String data) {
        int n = data.length();
        data = data.substring(1, n-1);
        List<String> listResult = cServices.search(data);
        return listResult;
    }    
}