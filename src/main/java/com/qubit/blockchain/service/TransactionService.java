package com.qubit.blockchain.service;

import java.util.List;

import com.qubit.blockchain.entity.Transaction;

public interface TransactionService {
	
	public List<Transaction> findAll();

	public List<Transaction> findByBlockHash(String block);

}
