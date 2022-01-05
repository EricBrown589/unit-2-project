package com.banking.bankingapi.controller;

import com.banking.bankingapi.model.Account;
import com.banking.bankingapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/accounts")
public class AccountsController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<Account> getAccounts(){
        return userService.getAccounts();
    }

    @PutMapping("/{accountId}")
    public List<Account> getAccount(@PathVariable Long accountId)){
        return userService.getAccount(accountId);
    }

}
