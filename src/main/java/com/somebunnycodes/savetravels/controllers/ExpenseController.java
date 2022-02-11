package com.somebunnycodes.savetravels.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.somebunnycodes.savetravels.models.Expense;
import com.somebunnycodes.savetravels.services.ExpenseService;

@Controller
public class ExpenseController {

	private final ExpenseService service;
	
	public ExpenseController(ExpenseService service) {
		this.service = service;
	}

	@RequestMapping("/")
	public String index(@ModelAttribute("expense") Expense expense, Model model) {
		List<Expense> expenses = service.allExpenses();
		model.addAttribute("expenses", expenses);
		return "index.jsp";
	}
	
	@RequestMapping(value="/expenses", method=RequestMethod.POST)
	public String createExpense(@Valid @ModelAttribute("expense") Expense expense, BindingResult result, Model model) {
		if (result.hasErrors()) {
            return index(expense, model);
        }
		
		// Store expense in database
		service.createExpense(expense);
		// Redirect to index
		return "redirect:/";
	}

	@RequestMapping(value="/expenses/{id}", method=RequestMethod.PUT)
	public String updateExpense(@PathVariable long id, @Valid @ModelAttribute("expense") Expense expense, BindingResult result, Model model) {
		if (result.hasErrors()) {
            return "edit.jsp";
        }
		
		expense.setId(id);
		
		// Store expense in database
		service.updateExpense(expense);
		// Redirect to index
		return "redirect:/";
	}

	
	@RequestMapping(value="/expenses/{id}", method=RequestMethod.DELETE)
	public String deleteExpense(@PathVariable long id) {
		service.deleteExpense(id);
		return "redirect:/";
	}
	
	@RequestMapping("/expenses/{id}")
	public String showExpense(@PathVariable long id, Model model) {
		Expense expense = service.findExpense(id);
		model.addAttribute("expense", expense);
		return "show.jsp";
	}
	
	@RequestMapping("/edit/{id}")
	public String editExpense(@PathVariable long id, Model model) {
		Expense expense = service.findExpense(id);
		model.addAttribute("expense", expense);
		return "edit.jsp";
	}
}
