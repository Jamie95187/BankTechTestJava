package bankSystem;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Statement {
	
	// Create field variables
	
	public void printStatement(TransactionHistory transactionHistory) {
		String script = "Date || Credit || Debit || Balance";
		List<HashMap<String,String>> log = transactionHistory.getLog();
		Collections.reverse(log);
		if(log.size() > 0) {
			for(HashMap<String, String> transaction : log) {
				if(transaction.get("Action") == "Deposit") {
					script = script + "\n01/01/2020 || 1000.00 || || 1000.00";
				};
			};
		};
		
//		for(int i = 0; i < log.size(); i++) {
//			System.out.println(log.get(i).get("Action"));
//		}
		
		System.out.print(script);
	}
	
}
