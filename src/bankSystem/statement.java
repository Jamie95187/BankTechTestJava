package bankSystem;

import java.util.Collections;

public class Statement {
	
	public static void printStatement(TransactionHistory transactionHistory) {
		String script = "Date || Credit || Debit || Balance";
		Collections.reverse(transactionHistory.getStatementLog());
		for(String transactionStatement : transactionHistory.getStatementLog()){
			script = script + transactionStatement;
		}
		System.out.print(script);
	}
	
}
