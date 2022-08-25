package com.example.project.controllers;

import com.example.project.clientsService.IClientService;
import com.example.project.countriesService.ICountryService;
import com.example.project.models.ClientModel;

import com.example.project.models.CountryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CountryController {

    @Autowired
    private IClientService clientService;
    @Autowired
    private ICountryService countryService;

    @GetMapping("/countries")
    public List<CountryModel> getCountries() {
        return countryService.getCountries();
    }

    @PostMapping("/countries")
    public String createCountry(@RequestBody CountryModel country) {
        countryService.saveCountry(country);
        return "The country was created successfully";
    }




}
