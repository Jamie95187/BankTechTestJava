package bankSystem;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Date;

public class Account {
	private TransactionHistory transactionHistory;
	
	public Account(TransactionHistory transactionHistoryParam) {
		this.transactionHistory = transactionHistoryParam;
	}
	
	public ArrayList<HashMap<String, String>> deposit(int amount) {
		// Create date object and change the format to store into the transaction
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	    Date date = new Date();
		HashMap<String, String> transaction = new HashMap<String, String>(){{
			put("Action", "Deposit");
			put("Date", dateFormat.format(date));
			put("Amount", Integer.toString(amount));
		}};
		transactionHistory.addTransaction(transaction);
		return transactionHistory.getLog();
	};
	
	public ArrayList<HashMap<String, String>> withdraw(int amount) {
		// Create date object and change the format to store into the transaction
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	    Date date = new Date();
		HashMap<String, String> transaction = new HashMap<String, String>(){{
			put("Action", "Withdraw");
			put("Date", dateFormat.format(date));
			put("Amount", Integer.toString(amount));
		}};
		transactionHistory.addTransaction(transaction);
		return transactionHistory.getLog();
	};
	
	// Overloading the deposit method to use testing
	public ArrayList<HashMap<String, String>> deposit(int amount, String date) {
		HashMap<String, String> transaction = new HashMap<String, String>(){{
			put("Action", "Deposit");
			put("Date", date);
			put("Amount", Integer.toString(amount));
		}};
		transactionHistory.addTransaction(transaction);
		return transactionHistory.getLog();
	};
	
	// Overloading the withdraw method to use for testing
	public ArrayList<HashMap<String, String>> withdraw(int amount, String date) {
		HashMap<String, String> transaction = new HashMap<String, String>(){{
			put("Action", "Withdraw");
			put("Date", date);
			put("Amount", Integer.toString(amount));
		}};
		transactionHistory.addTransaction(transaction);
		return transactionHistory.getLog();
	};
}
