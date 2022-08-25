package com.example.project.controllers;

import com.example.project.accountsService.IAccountService;
import com.example.project.clientsService.IClientService;
import com.example.project.countriesService.ICountryService;
import com.example.project.models.AccountsBankModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {

    @Autowired
    private IAccountService accountService;
    @Autowired
    private IClientService clientService;
    @Autowired
    private ICountryService countryService;


    @GetMapping("/accounts")
    public List<AccountsBankModel> getAccounts() {
        return accountService.getAccounts();
    }

    @GetMapping("/accounts/{id}")
    public AccountsBankModel getAccounts(@PathVariable Long id) {
        return accountService.findAccount(id);
    }





}
