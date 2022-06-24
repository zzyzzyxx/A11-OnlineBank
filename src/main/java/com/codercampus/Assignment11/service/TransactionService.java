package com.codercampus.Assignment11.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codercampus.Assignment11.domain.Transaction;
import com.codercampus.Assignment11.repository.TransactionRepository;

@Service
public class TransactionService {

	@Autowired
	private TransactionRepository tRepo;

	public List<Transaction> findAll() {
		List<Transaction> transactions = tRepo.findAll();
		Collections.sort(transactions);
		return transactions;
	}

	public Transaction findById(Long tId) {
	
		for(Transaction transaction : tRepo.findAll()) {
			if(transaction.getId().equals(tId)) {
				return transaction;
			}
		}
		return null;

	}

}
