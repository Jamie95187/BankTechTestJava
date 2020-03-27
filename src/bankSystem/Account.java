package bankSystem;

import java.util.ArrayList;
import java.util.HashMap;

public class Account {
	TransactionHistory transactionHistoryFieldVariable;
	
	Account(TransactionHistory transactionHistory) {
		transactionHistoryFieldVariable = transactionHistory;
	}
	
	public ArrayList<HashMap<String, String>> deposit(int amount) {
		HashMap<String, String> transaction = new HashMap<String, String>(){{
			put("Action", "Deposit");
			put("Date", "01/01/20");
			put("Amount", Integer.toString(amount));
		}};
		transactionHistoryFieldVariable.addTransaction(transaction);
		return transactionHistoryFieldVariable.getLog();
	};
	
	// Overloading the deposit method used for testing transactionHistory
	public ArrayList<HashMap<String, String>> deposit(int amount, String date) {
		HashMap<String, String> transaction = new HashMap<String, String>(){{
			put("Action", "Deposit");
			put("Date", date);
			put("Amount", Integer.toString(amount));
		}};
		transactionHistoryFieldVariable.addTransaction(transaction);
		return transactionHistoryFieldVariable.getLog();
	};
	
}
