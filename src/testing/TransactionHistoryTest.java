package testing;

import static org.junit.Assert.*;

import bankSystem.TransactionHistory;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

public class TransactionHistoryTest {
	
	private static TransactionHistory test;
	private HashMap<String, String> transactionDeposit;
	private HashMap<String, String> transactionWithdraw;
	
	@Before
	public void setupTests() {
		test = new TransactionHistory();
		transactionDeposit = new HashMap<String, String>(){{
			put("Action", "Deposit");
			put("Date", "01/01/2020");
			put("Amount", "1000");
		}};
	}
	
	@Test
	public void addTransaction_addOneTransaction_correctLog() {
		assertEquals(test.addTransaction(transactionDeposit), test.getLog());
		assertEquals(test.getLog().size(), 1);
	};
	
	@Test
	public void transactionToStatementInput_formatOneDepositTransaction_changeFormatOfTransaction() {
		assertEquals(test.transactionToStatementInput(transactionDeposit), "\n01/01/2020 || 1000.00 || || 1000.00");
	}
	
	@Test
	public void transactionToStatementInput_formatOneWithdrawTransactionAfterOneDeposit_changeFormatOfTransaction() {
		// Given balance is 1000.00 before withdraw
		transactionWithdraw = new HashMap<String, String>(){{
			put("Action", "Withdraw");
			put("Date", "02/01/2020");
			put("Amount", "500");
		}};
		assertEquals(test.transactionToStatementInput(transactionWithdraw, 1000.00), "\n02/01/2020 || || 500.00 || 500.00"); 
	}
}
