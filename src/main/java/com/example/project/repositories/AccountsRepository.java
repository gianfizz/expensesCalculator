package com.example.project.repositories;

import com.example.project.models.AccountsBankModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountsRepository extends JpaRepository<AccountsBankModel, Long> {
}
