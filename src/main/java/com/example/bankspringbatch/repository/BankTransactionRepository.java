package com.example.bankspringbatch.repository;

import com.example.bankspringbatch.model.BankTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankTransactionRepository extends JpaRepository <BankTransaction,Long> {
}
