package bankSystem;

import java.util.Collections;
import java.util.HashMap;

public class Statement {
	
	public void printStatement(TransactionHistory transactionHistory) {
		String script = "Date || Credit || Debit || Balance";
		Collections.reverse(transactionHistory.getStatementLog());
		for(String transactionStatement : transactionHistory.getStatementLog()){
			script = script + transactionStatement;
		}
		System.out.print(script);
	}
	
}
