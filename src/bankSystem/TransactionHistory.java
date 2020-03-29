package bankSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransactionHistory {
	
	// Field variable (instance variables)
	public List<HashMap<String, String>> log = new ArrayList<HashMap<String, String>>();
	public int balance = 0;
	
	public ArrayList<HashMap<String, String>> addTransaction(HashMap<String, String> transaction) {
		log.add(transaction);
		return (ArrayList<HashMap<String, String>>) log;
	}
	
	// Getter method
	public ArrayList<HashMap<String, String>> getLog(){
		return (ArrayList<HashMap<String, String>>) log;
	}
}
