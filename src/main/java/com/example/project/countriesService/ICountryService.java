package com.example.project.countriesService;

import com.example.project.models.CountryModel;

import java.util.List;

public interface ICountryService{

    public List<CountryModel> getCountries();

    public void saveCountry(CountryModel country);

    public void deleteCountry(Long id);

    public CountryModel findCountry(Long id);

}
