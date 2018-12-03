package comp1451.assignment3.data;

import java.util.ArrayList;
import java.util.Collections;

import comp1451.assignment3.collection.*;

public class BankReport implements Reporter{


	/**
	 * Default constructor
	 */
	public BankReport() {
		
	}
	
	/**
	 * Display account information by the account type entered in the console
	 */
	public void displayByCode(Bank theBank, String prefix) {
		for(BankCustomer customer: Bank.theBank.values()) {
			if(prefix != null && theBank != null && customer.getAccount().getAccountNumber().substring(0,2).equals(format(prefix))) {
				System.out.println(customer);
			}else {
				System.out.println("Please choose one of the types from the following: ch, gl, sa.");
			}
		}
	}

	/**
	 * Display all active account by their account number
	 * In Alphabetical order
	 */
	public void displayAllCodes(Bank theBank) {
		
		ArrayList<String> active = new ArrayList<String>();
		
		for(BankCustomer customer : Bank.theBank.values()) {
			if(theBank != null && customer.getAccount().isActive()) {
				active.add(customer.getAccount().getAccountNumber());
			}
		}
		Collections.sort(active);
		for(String accountNumber: active) {
			if(active != null) {
				System.out.println(accountNumber);
			}
		}
	}

	/**
	 * Display all inactive account by their account number
	 * in descending alphabetical order
	 */
	public void displayInactiveCodes(Bank theBank) {
		
		ArrayList<String> inactive = new ArrayList<String>();
		
		for(BankCustomer customer : Bank.theBank.values()) {
			if(theBank != null && !customer.getAccount().isActive()) {
				inactive.add(customer.getAccount().getAccountNumber());
			}
		}
		Collections.sort(inactive);
		Collections.reverse(inactive);
		for(String accountNumber : inactive) {
			if(inactive != null) {
				System.out.println(accountNumber);
			}
		}	
	}
	
	/**
	 * Display the total amount of all accounts in the bank
	 * @param theBank
	 * 				- the collection of BankCustomer
	 */
	public void displayAccountTotals(Bank theBank) {
		double sum = 0.0;
		
		for(BankCustomer customer : Bank.theBank.values()) {
			if(theBank != null) {
				sum = customer.getAccount().getBalance() + sum;
			}
		}
		System.out.println(String.format("The sum of all account balances in the bank is: $%1.2f", sum));
	}
	
	/**
	 * Format input string to all upper case
	 * @param s
	 * 		- is the input String
	 * @return s in String with all upper cases
	 */
	private String format(String s) {
		if(s != null && !s.trim().isEmpty()) {
			return s.toUpperCase();
		}else {
			return "";
		}
	}

	
}
