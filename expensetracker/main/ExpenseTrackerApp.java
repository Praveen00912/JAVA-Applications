package com.expensetracker.main;

import com.expensetracker.model.Expense;
import com.expensetracker.service.ExpenseService;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ExpenseTrackerApp {

    private static ExpenseService service = new ExpenseService();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {
            showMenu();

            try {
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine(); // consume newline

                handleUserChoice(choice);

            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.nextLine();
                choice = 0;
            }

        } while (true);
    }

    // Display menu
    public static void showMenu() {
        System.out.println("\nExpense Tracker Menu:");
        System.out.println("1. Add Expense");
        System.out.println("2. View All Expenses");
        System.out.println("3. View Expenses by Category");
        System.out.println("4. Calculate Total Expenses");
        System.out.println("5. Exit");
    }

    // Handle menu options
    public static void handleUserChoice(int choice) {
        switch (choice) {

            case 1:
                addExpense();
                break;

            case 2:
                viewAllExpenses();
                break;

            case 3:
                viewByCategory();
                break;

            case 4:
                calculateTotal();
                break;

            case 5:
                System.out.println("Goodbye!");
                System.exit(0);

            default:
                System.out.println("Invalid choice! Please select 1 to 5.");
        }
    }

    // Add Expense
    public static void addExpense() {
        try {
            System.out.print("Enter description: ");
            String description = scanner.nextLine();

            if (description.isEmpty()) {
                System.out.println("Description cannot be empty.");
                return;
            }

            System.out.print("Enter amount: ");
            double amount = scanner.nextDouble();
            scanner.nextLine();

            if (amount <= 0) {
                System.out.println("Amount must be positive.");
                return;
            }

            System.out.print("Enter category: ");
            String category = scanner.nextLine();

            if (category.isEmpty()) {
                System.out.println("Category cannot be empty.");
                return;
            }

            Expense expense = new Expense(description, amount, category);
            service.addExpense(expense);

            System.out.println("Expense added.");

        } catch (InputMismatchException e) {
            System.out.println("Invalid amount entered.");
            scanner.nextLine();
        }
    }

    // View all expenses
    public static void viewAllExpenses() {
        List<Expense> expenses = service.getAllExpenses();

        if (expenses.isEmpty()) {
            System.out.println("No expenses found.");
            return;
        }

        System.out.println("\nAll Expenses:");

        for (Expense expense : expenses) {
            System.out.println(expense);
        }
    }

    // View by category
    public static void viewByCategory() {
        System.out.print("Enter category to filter by: ");
        String category = scanner.nextLine();

        List<Expense> filtered = service.getExpensesByCategory(category);

        if (filtered.isEmpty()) {
            System.out.println("No expenses found in this category.");
            return;
        }

        System.out.println("\nExpenses in category '" + category + "':");

        for (Expense expense : filtered) {
            System.out.println(expense);
        }
    }

    // Calculate total
    public static void calculateTotal() {
        double total = service.calculateTotalExpenses();
        System.out.println("\nTotal Expenses: " + total);
    }
}