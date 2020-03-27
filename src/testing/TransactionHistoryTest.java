package testing;

import static org.junit.Assert.*;

import bankSystem.TransactionHistory;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class TransactionHistoryTest {
	
//	private static TransactionHistory test;
	
	@Test
	public void addTransaction_addOneTransaction_correctLog() {
		TransactionHistory test = new TransactionHistory();
		Map<String, String> transaction = new HashMap<String, String>(){{
			put("Action", "Deposit");
			put("Date", "01/01/20");
			put("Amount", "1000");
			put("Balance", "1000");
		}};
		// Make shallow copy of HashMap
		HashMap<String, String> transactionCopy = new HashMap<String,String>(transaction);
		assertEquals(test.addTransaction(transactionCopy), test.getLog());
	};

}