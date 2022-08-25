package com.example.project.countriesService;

import com.example.project.models.CountryModel;
import com.example.project.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService implements ICountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public List<CountryModel> getCountries() {
        List<CountryModel> countries = countryRepository.findAll();
        return countries;
    }

    @Override
    public void saveCountry(CountryModel countryModel) {
        countryRepository.save(countryModel);
    }

    @Override
    public void deleteCountry(Long id) {
        countryRepository.deleteById(id);
    }

    @Override
    public CountryModel findCountry(Long id) {
        CountryModel country = countryRepository.findById(id).orElse(null);
        return country;
    }

}
