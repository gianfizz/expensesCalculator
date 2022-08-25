package com.example.project.clientsService;

import com.example.project.ClientInformation;
import com.example.project.models.AccountsBankModel;
import com.example.project.models.ClientModel;
import com.example.project.repositories.AccountsRepository;
import com.example.project.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService implements IClientService {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private AccountsRepository accountsRepository;

    @Override
    public List<ClientModel> getClients() {
        List<ClientModel> clientModels = clientRepository.findAll();
        return clientModels;
    }

    public String getBalance(Long id) {
        ClientModel client = clientRepository.findById(id).orElse(null);
        return "The balance from " + client + " is $" + client.getBankAccount().getBalance();
    }

    public String deposit(Long id, Long depositAmount) {
        if (depositAmount <= 0) {
            return "You can't deposit that amount";
        } else {
            ClientModel clientModel = clientRepository.findById(id).orElse(null);
            Long balance = clientModel.getBankAccount().getBalance();
            balance =+ depositAmount;
            clientModel.getBankAccount().setBalance(balance);
            return "You deposited $"+depositAmount+" and now you have $"+balance;
        }
    }

    public String withdraw(Long id, Long withdrawAmount) {
        if (withdrawAmount <= 0) {
            return "You can't withdraw that amount";
        } else if(clientRepository.findById(id).orElse(null).getBankAccount().getBalance() - withdrawAmount < 0) {
            return "You don't have that much money";
        } else {
            ClientModel clientModel = clientRepository.findById(id).orElse(null);
            Long balance = clientModel.getBankAccount().getBalance();
            balance =- withdrawAmount;
            clientModel.getBankAccount().setBalance(balance);
            return "You deposited $"+withdrawAmount+" and now you have $"+balance;
        }
    }

    public ClientInformation createClient(ClientInformation client) {
        AccountsBankModel accountsBankModel = new AccountsBankModel();
        accountsBankModel.setAccountNumber(client.getAccount());
        ClientModel clientModel = new ClientModel();
        clientModel.setName(client.getName());
        clientModel.setSurname(client.getSurname());
        clientModel.setBankAccount(accountsBankModel);
        clientRepository.save(clientModel);
        return client;
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public ClientModel findClient(Long id) {
        ClientModel client = clientRepository.findById(id).orElse(null);
        return client;
    }

}
