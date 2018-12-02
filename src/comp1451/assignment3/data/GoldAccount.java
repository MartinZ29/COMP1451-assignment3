package comp1451.assignment3.data;

import java.util.Date;

/**
 * GoldAccount data class
 * 
 * @author Bullwinkle Moose
 * @version 1.0
 */
public class GoldAccount extends Account {

	private boolean overdraft;

	public static final double INTEREST_RATE = 0.025;
	public static final double FEE = 10.0;
	public static final double OVERDRAFT_AMT = -5000.0;

	/**
	 * Default constructor
	 */
	public GoldAccount() {
		super();
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
	public GoldAccount(double balance, String accountNumber) {
		super(balance, accountNumber);
		overdraft = false;
	}

	/**
	 * 
	 * @return the interestRate as double
	 */
	public double getInterestRate() {

		return INTEREST_RATE;
	}

	/**
	 * 
	 * @return the inOverdraft as boolean
	 */
	public boolean isOverdraft() {

		return overdraft;
	}

	/**
	 * 
	 * @param inOverdraft
	 *            the inOverdraft to set
	 */
	public void setOverdraft(boolean overdraft) {

		this.overdraft = overdraft;
	}

	/**
	 * Implement abstract method from abstract class
	 */
	public void addTransaction(String transactionInfo) {
		if(getAccountNumber() != null && !getAccountNumber().trim().isEmpty()) {
			accountRecords.add(transactionInfo);
		}
	}
	
	/**
	 *  Implement abstract method from abstract class
	 * @param amount
	 * 			- the amount subtract from the accounts
	 */
	public void subtractFromBalance(double amount) {
		if (getBalance() - amount >= GoldAccount.OVERDRAFT_AMT) {
			setBalance(getBalance() - amount);
			addTransaction(String.format("%s - withdrawal: $%.2f", new Date(), amount));
		}
	}

	/**
	 * toString method
	 */
	@Override
	public String toString() {
		return "GoldAccount [interestRate=" + INTEREST_RATE + ", overdraft=" + overdraft + ", toString()="
				+ super.toString() + "]";
	}

}

