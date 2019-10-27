package com.example.demo;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.Set;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {
    Set<Transaction> findById(long id);

}
