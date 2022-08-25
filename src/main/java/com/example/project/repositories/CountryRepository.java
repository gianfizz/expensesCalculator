package com.example.project.repositories;

import com.example.project.models.CountryModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<CountryModel, Long> {
}
