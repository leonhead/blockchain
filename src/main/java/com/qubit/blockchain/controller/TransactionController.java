package com.qubit.blockchain.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qubit.blockchain.entity.Transaction;
import com.qubit.blockchain.service.TransactionService;

@RestController
@RequestMapping("transactions")
@CrossOrigin("http://localhost:4200")
public class TransactionController {
	
	@Autowired
	private TransactionService transactionService;
	
	@GetMapping("list")
	private List<Transaction> getTransactions(){
		List<Transaction> transactions = transactionService.findAll();
		return transactions;
	}

}
