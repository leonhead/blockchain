package com.qubit.blockchain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qubit.blockchain.dao.TransactionRepository;
import com.qubit.blockchain.entity.Transaction;

@Service
public class TransactionServiceImpl implements TransactionService {
	
	@Autowired
	private TransactionRepository transactionRepository;

	@Override
	public List<Transaction> findAll() {
		List<Transaction> transactions = transactionRepository.findAll();
		return transactions;
	}

}
