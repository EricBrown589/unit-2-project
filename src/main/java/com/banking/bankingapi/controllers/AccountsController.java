package com.banking.bankingapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/hello")
public class AccountsController {
    @GetMapping
    public String hello(){
        return "Hello World!!!!!";
    }
}
