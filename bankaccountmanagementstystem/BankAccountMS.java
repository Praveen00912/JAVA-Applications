package com.bankaccountmanagementstystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankAccountMS {
    public static void deposit(List<Accounts> a, int accountId, double amount) {
        for (Accounts acc : a) {
            if (acc.id == accountId) {
                acc.balance += amount;
            }
        }
    }
    public static void withdraw(List<Accounts> a, int accountId, double amount) {
        for (Accounts acc : a) {
            if (acc.id == accountId && acc.balance >= amount) {
                acc.balance -= amount;
            }
        }
    }
    public static void removeLowBal(List<Accounts> a, double minBal) {
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).balance < minBal) {
                a.remove(i);
                i--;
            }
        }
    }
    public static void main(String[] args) {
        List<Customer> cs = new ArrayList<>();
        cs.add(new Customer(1, "John", "Hyderabad"));
        cs.add(new Customer(2, "Alice", "Mumbai"));
        cs.add(new Customer(3, "Bob", "Hyderabad"));
        
        List<Accounts> a = new ArrayList<>();
        a.add(new Accounts(101, 1, 7000, "Current account"));
        a.add(new Accounts(102, 2, 9000, "Saving account"));
        a.add(new Accounts(103, 3, 3000, "Saving account"));

        deposit(a, 101, 0);
        withdraw(a, 102, 0);
        
        Map<Integer, Customer> customerMap = new HashMap<>();
        for (Customer c : cs) {
            customerMap.put(c.id, c);
        }

        System.out.println("Customers from Hyderabad:");
        for (Customer c : cs) {
            if (c.city.equalsIgnoreCase("Hyderabad")) {
                System.out.println(c.name);
            }
        }

        System.out.println("\nAccounts with balance > 5000:");
        for (Accounts acc : a) {
            if (acc.balance > 5000) {
                System.out.println(acc.id + " -> " +(int)acc.balance);
            }
        }

        System.out.println("\nSorted Accounts:");
        a.sort((acc, b) -> Double.compare(b.balance, acc.balance));

        for (Accounts acc : a) {
            System.out.println(acc.id + " -> " +(int)acc.balance);
        }

        System.out.println("\nAccount-Customer Mapping:");
        for (Accounts acc : a) {
            Customer c = customerMap.get(acc.customerId);
            System.out.println(acc.id + " -> " + c.name + " -> " +(int)acc.balance);
        }
    }
}