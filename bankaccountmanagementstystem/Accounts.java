package com.bankaccountmanagementstystem;

public class Accounts {
	int id;
	int customerId;
	double balance;
	String type;
	public Accounts(int id, int customerId, double balance, String type) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.balance = balance;
		this.type = type;
	}
}