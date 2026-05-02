package com.expensetracker.service;

import com.expensetracker.model.Expense;
import com.expensetracker.util.FileUtil;

import java.util.ArrayList;
import java.util.List;

public class ExpenseService {

    private ArrayList<Expense> expenses;

    public ExpenseService() {
        expenses = new ArrayList<>();
        loadExpenses();
    }

    // Add Expense
    public void addExpense(Expense expense) {
        expenses.add(expense);
        saveExpenses();
    }

    // Get all expenses
    public List<Expense> getAllExpenses() {
        return expenses;
    }

    // Filter by category
    public List<Expense> getExpensesByCategory(String category) {
        List<Expense> filtered = new ArrayList<>();

        for (Expense expense : expenses) {
            if (expense.getCategory().equalsIgnoreCase(category)) {
                filtered.add(expense);
            }
        }

        return filtered;
    }

    // Calculate total expenses
    public double calculateTotalExpenses() {
        double total = 0;

        for (Expense expense : expenses) {
            total += expense.getAmount();
        }

        return total;
    }

    // Load expenses from file
    public void loadExpenses() {
        expenses = new ArrayList<>(FileUtil.readFromFile());
    }

    // Save expenses to file
    public void saveExpenses() {
        FileUtil.writeToFile(expenses);
    }
}