package com.qubit.blockchain.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qubit.blockchain.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, String>{

}
