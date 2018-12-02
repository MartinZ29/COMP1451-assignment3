package comp1451.assignment3.data;

/**
 * ChequingAccount data class
 * 
 * @author Bullwinkle Moose
 * @version 1.0
 */
public class ChequingAccount extends Account {
	
	public static final double FEE = 0.25;
	private static final double MIN_AMOUNT = 0.0;
	private int numberOfCheques;
	private double totalFees;

	/**
	 * Default constructor
	 */
	public ChequingAccount() {
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
	public ChequingAccount(double balance, String accountNumber) {

		super(balance, accountNumber);
		numberOfCheques = 0;
	}

	/**
	 * 
	 * @return the numberOfCheques as int
	 */
	public int getNumberOfCheques() {

		return numberOfCheques;
	}

	/**
	 * 
	 * @param numberOfCheques
	 *            the numberOfCheques to set
	 */
	public void setNumberOfCheques(int numberOfCheques) {

		if (numberOfCheques > 0) {
			this.numberOfCheques = numberOfCheques;
		}
	}
	
	/**
	 * Adds 1 to the number of cheques whenever there is a withdrawal 
	 * from a ChequingAccount
	 */
	public void addACheque(){
		
		numberOfCheques ++;
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
			addACheque();
			totalFees = numberOfCheques * FEE;

		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ChequingAccount [numberOfCheques=" + numberOfCheques + ", totalFees=" + totalFees + ", toString()="
				+ super.toString() + "]";
	}

	

}
