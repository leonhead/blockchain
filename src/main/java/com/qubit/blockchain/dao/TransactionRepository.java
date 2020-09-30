package com.qubit.blockchain.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qubit.blockchain.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, String>{
	
	public List<Transaction> findByBlock_hash(String hash);

}
