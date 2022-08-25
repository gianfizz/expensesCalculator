package com.example.project.bankService;

import com.example.project.models.BankModel;
import com.example.project.repositories.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankService implements IBankService{

    @Autowired
    private BankRepository bankRepository;

    @Override
    public List<BankModel> getBanks() {
        List<BankModel> banks = bankRepository.findAll();
        return banks;
    }

    @Override
    public BankModel saveBank(BankModel bank) {
        return bankRepository.save(bank);
    }

    @Override
    public void deleteBank(Long id) {
        bankRepository.deleteById(id);
    }

    @Override
    public BankModel findBank(Long id) {
        BankModel bank = bankRepository.findById(id).orElse(null);
        return bank;
    }

}
