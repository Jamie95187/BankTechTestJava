package bankSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TransactionHistory {
	
	// Field variable (instance variables)
	
	public List<HashMap<String, String>> log = new ArrayList<HashMap<String, String>>();
	private ArrayList<String> statementLog = new ArrayList<String>();
	private Double balance = 0.0;
	
	public ArrayList<HashMap<String, String>> addTransaction(HashMap<String, String> transaction) {
		log.add(transaction);
		statementLog.add(transactionToStatementInput(transaction));
		return (ArrayList<HashMap<String, String>>) log;
	};
	
	public String transactionToStatementInput(HashMap<String, String> transaction) {
		if(transaction.get("Action") == "Deposit") {
			balance += Integer.parseInt(transaction.get("Amount"));
			return "\n" + transaction.get("Date") + " || " + transaction.get("Amount") + ".00 || || " + String.format("%.2f", balance);
		} else {
			balance -= Integer.parseInt(transaction.get("Amount"));
			return "\n" + transaction.get("Date") + " || || " + transaction.get("Amount") + ".00 || " + String.format("%.2f", balance);
		}
	};
	
	// Overload method to test for when action is withdraw
	
	public String transactionToStatementInput(HashMap<String, String> transaction, Double balance) {
		if(transaction.get("Action") == "Deposit") {
			balance += Integer.parseInt(transaction.get("Amount"));
			return "\n" + transaction.get("Date") + " || " + transaction.get("Amount") + ".00 || || " + String.format("%.2f", balance);
		} else {
			balance -= Integer.parseInt(transaction.get("Amount"));
			return "\n" + transaction.get("Date") + " || || " + transaction.get("Amount") + ".00 || " + String.format("%.2f", balance);
		}
	};
	
	// Getter methods
	
	public ArrayList<HashMap<String, String>> getLog(){
		return (ArrayList<HashMap<String, String>>) log;
	};
	
	public ArrayList<String> getStatementLog(){
		return statementLog;
	};
}
