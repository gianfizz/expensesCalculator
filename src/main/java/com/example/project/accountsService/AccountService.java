package com.example.project.accountsService;

import com.example.project.models.AccountsBankModel;
import com.example.project.repositories.AccountsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService implements IAccountService{

    @Autowired
    private AccountsRepository accountsRepository;

    @Override
    public List<AccountsBankModel> getAccounts() {
        List<AccountsBankModel> accountsBanks = accountsRepository.findAll();
        return accountsBanks;
    }

    @Override
    public AccountsBankModel saveAccount(AccountsBankModel accountsBank) {
        return accountsRepository.save(accountsBank);
    }

    @Override
    public void deleteAccount(Long id) {
        accountsRepository.deleteById(id);
    }

    @Override
    public AccountsBankModel findAccount(Long id) {
        AccountsBankModel accountsBank = accountsRepository.findById(id).orElse(null);
        return  accountsBank;
    }

}
