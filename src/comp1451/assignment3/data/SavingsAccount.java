package comp1451.assignment3.data;

import java.util.Date;

/**
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
	 * @return the minAmount constant as a double
	 */
	public static double getMinAmount() {
		return MIN_AMOUNT;
	}
	
	/**
	 * 
	 */
	public void addTransaction(String transactionInfo) {
		if(getAccountNumber() != null && !getAccountNumber().trim().isEmpty()) {
			accountRecords.add(transactionInfo);
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
