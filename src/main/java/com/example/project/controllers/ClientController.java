package com.example.project.controllers;

import com.example.project.ClientInformation;
import com.example.project.accountsService.IAccountService;
import com.example.project.clientsService.IClientService;
import com.example.project.countriesService.ICountryService;
import com.example.project.models.ClientModel;

import com.example.project.models.CountryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientController {

    @Autowired
    private IClientService clientService;
    @Autowired
    private ICountryService countryService;
    @Autowired
    private IAccountService accountService;


    //GET
    @GetMapping("/clients")
    public List<ClientModel> getClients() {
        return clientService.getClients();
    }

    @GetMapping("/clients/{id}")
    public ClientModel getClient(@PathVariable Long id) {
        return clientService.findClient(id);
    }

    @GetMapping("/getClientsAndCountry/{id}")
    public String getClientsAndCountry(@PathVariable Long id) {
        return clientService.findClient(id).getName() + " is from " + clientService.findClient(id).getCountry();
    }

    @GetMapping("/clients/balance/{id}")
    public String getBalance(@PathVariable Long id) {
        ClientModel client = clientService.findClient(id);
        return "The balance from "+client+" is $"+client.getBankAccount().getBalance();
    }

    //POST
    @PostMapping("/clients")
    public ClientInformation createClient(@RequestBody ClientInformation client) {
        ClientModel clientModel = new ClientModel();
        clientService.createClient(client);
        return client;
    }


    //DELETE
    @DeleteMapping("/clients/{id}")
    public String deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
        return "The client was deleted successfully";
    }


    //PUT
    @PutMapping("/clients/{id}")
    public ClientModel editClient(@PathVariable Long id,
                                  @RequestParam("name") String newName,
                                  @RequestParam("surname") String newSurname) {
        ClientModel client = clientService.findClient(id);
        client.setName(newName);
        client.setSurname(newSurname);
        return client;
    }

    @PutMapping("/clients/deposit/{id}/{depositAmount}")
    public String deposit(@PathVariable Long id, @PathVariable Long depositAmount) {
        Long balance = clientService.findClient(id).getBankAccount().getBalance();
        balance =+ depositAmount;
        clientService.findClient(id).getBankAccount().setBalance(balance);
        return "You deposited $"+depositAmount+" and now you have $"+balance+" into "+clientService.findClient(id);
    }

    @PutMapping("/clients/deposit/{id}/{depositAmount}")
    public String withdraw(@PathVariable Long id, @PathVariable Long withdrawAmount) {
        Long balance = clientService.findClient(id).getBankAccount().getBalance();
        balance =- withdrawAmount;
        clientService.findClient(id).getBankAccount().setBalance(balance);
        return "You deposited $"+withdrawAmount+" and now you have $"+balance+" into "+clientService.findClient(id);
    }





}
