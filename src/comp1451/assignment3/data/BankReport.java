package comp1451.assignment3.data;

import java.util.ArrayList;
import java.util.Collections;

import comp1451.assignment3.collection.*;

public class BankReport implements Reporter{


	public BankReport() {
		
	}
	
	public void displayByCode(Bank theBank, String prefix) {
		for(BankCustomer customer: Bank.theBank.values()) {
			if(prefix != null && theBank != null && customer.getAccount().getAccountNumber().substring(0,2).equals(format(prefix))) {
				System.out.println(customer);
			}else {
				System.out.println("Please enter correct category");
			}
		}
	}


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
