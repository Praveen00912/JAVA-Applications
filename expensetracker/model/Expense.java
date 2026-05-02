package com.expensetracker.model;

public class Expense {
	String description;
	double amount;
	String category;
	public Expense(String description, double amount, String category) {
		super();
		this.description = description;
		this.amount = amount;
		this.category = category;
	}
	@Override
	public String toString() {
		return "Expense [description=" + description + ", amount=" + amount + ", category=" + category + "]";
	}
	public String getDescription() {
		return description;
	}
	public double getAmount() {
		return amount;
	}
	public String getCategory() {
		return category;
	}
	
	  // toCSV method
    public String toCSV() {
        return description + "," + amount + "," + category;
    }
    
    public static Expense parseExpense(String line) {
        String[] parts = line.split(",");
        if (parts.length != 3) {
            throw new IllegalArgumentException("Invalid CSV format");
        }
        String description = parts[0];
        double amount = Double.parseDouble(parts[1]);
        String category = parts[2];

        return new Expense(description, amount, category);
    }

}