package com.codercampus.Assignment11.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.codercampus.Assignment11.domain.Transaction;
import com.codercampus.Assignment11.service.TransactionService;

@Controller
public class TransactionController {
	
	@Autowired
	private TransactionService tService;
	
	@GetMapping("/transactions")
	public String getTransactions (ModelMap model) {
		List<Transaction> transactions = tService.findAll();
		
		model.put("transactions", transactions);
		
		return "transactions";
		
	}
	
	@GetMapping("/transactions/{tId}")
	public String getTransaction (ModelMap model, @PathVariable Long tId) {
		Transaction transaction = tService.findById(tId);
		model.put("transaction", transaction);
		return "transaction";
	}
}

	