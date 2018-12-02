package comp1451.assignment3.data;

import java.util.ArrayList;
import java.util.Date;

/**
 * BCIT COMP1451 assignment3
 * Student id# 01013955  Yuxing Zhang
 * 
 * @author Martin
 * @version Dec 02, 2018
 * 
 * Import solution for assignment 2 as starter
 * 
 * Import info as follow:
 * Account super class
 * 
 * @author Bullwinkle Moose
 * @version 1.0
 * 
 */

public abstract class Account {
	private double balance;
	private String accountNumber;
	private boolean active;
	protected ArrayList<String> accountRecords;

	/**
	 * Default constructor
	 */
	public Account() {
	}

	/**
	 * Overloaded constructor
	 * 
	 * @param balance
	 *            the balance to set
	 * @param accountNumber
	 *            the account number to set
	 *            
	 */
	public Account(double balance, String accountNumber) {
		setBalance(balance);
		setAccountNumber(accountNumber);
		active = true;
		accountRecords = new ArrayList<String>();
	}

	/**
	 * Accessor of balance
	 * @return the balance as double
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * Mutator of balance
	 * @param balance
	 *            the balance to set
	 */
	public void setBalance(double balance) {
		if (balance >= 0) {
			this.balance = balance;
		}
	}

	/**
	 * Accessor of accountNumber
	 * @return the accountNumber as String
	 */
	public String getAccountNumber() {
		return accountNumber;
	}

	/**
	 * Mutator of accountNumber
	 * @param accountNumber
	 *            the accountNumber to set
	 */
	public void setAccountNumber(String accountNumber) {
		if (accountNumber != null && !accountNumber.trim().isEmpty()) {
			this.accountNumber = accountNumber;
		}
	}

	/**
	 * Accessore of active
	 * @return the active as boolean
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * Mutator of active
	 * @param active
	 *            the active to set
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

	/**
	 * Abstrct method addTransaction
	 * @param transactionInfo
	 *            the information to add to ArrayList
	 */
	public abstract void addTransaction(String transactionInfo);

	/**
	 * Displays the transaction information.
	 */
	public void displayAccountRecords() {
		System.out.println("Acount Activity: ");
		for (String info : accountRecords) {
			System.out.println(info);
		}
	}

	/**
	 * 
	 * @param amount
	 *            the amount to add to the existing field
	 */
	public void addToBalance(double amount) {
		if (amount > 0.0) {
			balance += amount;
			addTransaction(String.format("%s - deposit: $%.2f", new Date(), amount));
		}
	}

	/**
	 * Abstract method of subtractFromBalance
	 * @param amount
	 *            the amount to subtract from the balance
	 */
	public abstract void subtractFromBalance(double amount);

	/**
	 * toString method
	 */
	@Override
	public String toString() {
		return "Account [balance=" + balance + ", accountNumber="
				+ accountNumber + ", active=" + active + "]";
	}

}