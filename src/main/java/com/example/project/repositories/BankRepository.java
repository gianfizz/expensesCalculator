package com.example.project.repositories;

import com.example.project.models.BankModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepository extends JpaRepository<BankModel, Long> {
}
