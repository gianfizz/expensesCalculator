package com.example.project.models;

import javax.persistence.*;

@Entity
public class CountryModel {

    private String countryName;

    @Id
    @Column(name = "Id")
    @GeneratedValue
    private Long countryId;

    public CountryModel() {}

    public CountryModel(Long id) {
        this.countryId = id;
    }

    public Long getCountryId() {
        return countryId;
    }

    public CountryModel(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

}
