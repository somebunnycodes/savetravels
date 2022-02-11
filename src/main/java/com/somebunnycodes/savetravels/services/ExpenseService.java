package com.somebunnycodes.savetravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.somebunnycodes.savetravels.models.Expense;
import com.somebunnycodes.savetravels.repositories.ExpenseRepository;

@Service
public class ExpenseService {

	private final ExpenseRepository repository;
	
	public ExpenseService(ExpenseRepository repository) {
		this.repository = repository;
	}

    public List<Expense> allExpenses() {
        return repository.findAll();
    }
    
    public Expense createExpense(Expense e) {
        return repository.save(e);
    }
    
    public void deleteExpense(Long id) {
    	repository.deleteById(id);
    }

    public void updateExpense(Expense expense) {
    	repository.save(expense);
    }
    
    public Expense findExpense(Long id) {
        Optional<Expense> optionalExpense = repository.findById(id);
        if(optionalExpense.isPresent()) {
            return optionalExpense.get();
        } else {
            return null;
        }
    }
	
}
