package com.example.project.bankService;

import com.example.project.models.BankModel;

import java.util.List;

public interface IBankService {

    public List<BankModel> getBanks();

    public BankModel saveBank(BankModel bank);

    public void deleteBank(Long id);

    public BankModel findBank(Long id);
}
