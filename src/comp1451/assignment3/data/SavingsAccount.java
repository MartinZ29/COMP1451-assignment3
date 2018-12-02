package comp1451.assignment3.data;

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
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see Account#subtractFromBalance(double)
	 */
	@Override
	public void subtractFromBalance(double amount) {

		if (getBalance() - amount >= MIN_AMOUNT) {
			
			super.subtractFromBalance(amount);	

		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SavingsAccount [toString()=" + super.toString() + "]";
	}

	
}
