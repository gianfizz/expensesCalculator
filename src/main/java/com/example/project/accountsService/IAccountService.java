package com.example.project.accountsService;

import com.example.project.models.AccountsBankModel;

import java.util.List;

public interface IAccountService {

    public List<AccountsBankModel> getAccounts();

    public AccountsBankModel saveAccount(AccountsBankModel accountsBank);

    public void deleteAccount(Long id);

    public AccountsBankModel findAccount(Long id);
}
