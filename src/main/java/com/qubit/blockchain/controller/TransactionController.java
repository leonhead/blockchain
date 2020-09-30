package com.qubit.blockchain.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qubit.blockchain.entity.Transaction;
import com.qubit.blockchain.service.TransactionService;

@RestController
@RequestMapping("api")
@CrossOrigin("http://localhost:4200")
public class TransactionController {
	
	@Autowired
	private TransactionService transactionService;
	
	@GetMapping("transactions")
	public List<Transaction> getTransactions(){
		List<Transaction> transactions = transactionService.findAll();
		return transactions;
	}
	
	@GetMapping("transactions/search/findByBlockHash")
	public List<Transaction> findByBlockHash(@RequestParam String block){
		List<Transaction> transactions = transactionService.findByBlockHash(block);
		return transactions;
	}

}
