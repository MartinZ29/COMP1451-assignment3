package comp1451.assignment3.data;

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
 * SavingsAccount data class
 * 
 * @author Bullwinkle Moose
 * @version 1.0
 */
public class SavingsAccount extends Account {
	
	public static final double MIN_AMOUNT = 100.0;

	/**
	 * Default constructor
	 */
	public SavingsAccount() {
		super();
	}

	/**
	 * Overloaded constructor
	 * 
	 * @param balance
	 *            the balance to set
	 * @param accountNumber
	 *            the account number to set
	 */
	public SavingsAccount(double balance, String accountNumber) {
		super(balance, accountNumber);
	}
		

	/**
	 * Accessor of MIN_AMOUNT
	 * @return the minAmount constant as a double
	 */
	public static double getMinAmount() {
		return MIN_AMOUNT;
	}
	
	/**
	 * Implement abstract method from abstract class
	 */
	public void addTransaction(String transactionInfo) {
		if(getAccountNumber() != null && !getAccountNumber().trim().isEmpty()) {
			accountRecords.add(transactionInfo);
			System.out.println("You balance is: " + getBalance() + ", minium active amount is: " + MIN_AMOUNT + ". You account is active: " + isActive());
		}
	}
		
	/**
	 * Implement abstract method from abstract class
	 * @param amount
	 * 			- the amount subtract from the account
	 */
	public void subtractFromBalance(double amount) {

		if (getBalance() - amount >= MIN_AMOUNT) {
			setBalance(getBalance() - amount);
			addTransaction(String.format("%s - withdrawal: $%.2f", new Date(), amount));
		}else if(getBalance() - amount < MIN_AMOUNT && getBalance() - amount >= 0 ) {
			setBalance(getBalance() - amount);
			setActive(false);
			addTransaction(String.format("%s - withdrawal: $%.2f", new Date(), amount));
		}else {
			System.out.println("Sorry. You do not have enough balance.");
		}
	}

	/**
	 * toString method
	 */
	@Override
	public String toString() {
		return "SavingsAccount [toString()=" + super.toString() + "]";
	}

}
