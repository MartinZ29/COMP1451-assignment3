package comp1451.assignment3.data;

import comp1451.assignment3.collection.Bank;

 /** 
 * BCIT COMP1451 assignment3
 * Student id# 01013955  Yuxing Zhang
 * 
 * @author Martin
 * @version Dec 02, 2018
 *
 */
public interface Reporter {

	/**
	 * Display information of accounts according to prefix in the records.
	 * @param records
	 * 				- is the accounts in the bank in HashMap
	 * @param prefix
	 * 				- is type of the account set for the account number
	 */
	void displayByCode(Bank records, String prefix);
	
	/**
	 * Display all accounts information in the records.
	 * @param records
	 *				 - is the accounts in the bank in HashMap
	 */
	void displayAllCodes(Bank records);
	
	/**
	 * Display all inactive accounts in the records
	 * @param records
	 * 				- is the accounts in the bank in HashMap
	 */
	void displayInactiveCodes(Bank records);
}
