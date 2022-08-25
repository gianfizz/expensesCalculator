package com.example.project.models;

import javax.persistence.*;

@Entity
public class ClientModel {

    @Id
    @GeneratedValue
    @Column(name = "Id")
    private Long clientId;

    @Column(name = "name")
    private String name;
    private String surname;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private CountryModel country;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id")
    private AccountsBankModel bankAccount;

    public AccountsBankModel getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(AccountsBankModel bankAccount) {
        this.bankAccount = bankAccount;
    }

    public CountryModel getCountry() {
        return country;
    }

    public void setCountry(CountryModel country) {
        this.country = country;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }



}
