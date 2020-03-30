package testing;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import bankSystem.Account;
import bankSystem.TransactionHistory;

public class AccountTest {
	
	private Account test;
	private ArrayList<HashMap<String, String>> mockedLog;
	
	@Mock
	private TransactionHistory mockedTransactionHistory = mock(TransactionHistory.class);
	
	@Before
	public void setUpTests() {
		test = new Account(mockedTransactionHistory);
		// Add one deposit transaction to the mockedLog
		mockedLog = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> mockedTransaction = new HashMap<String,String>(){{
			put("Action", "Deposit");
			put("Date", "01/01/2020");
			put("Amount", "1000");
		}};
		mockedLog.add(mockedTransaction);
		when(mockedTransactionHistory.getLog()).thenReturn(mockedLog);
	};
	
	@After
	public void clearMockedData() {
		mockedLog.clear();
	}
	
	@Test
	public void account_deposit_returnTransactionLog() {
		assertEquals(1, mockedLog.size());
		assertEquals(mockedLog, test.deposit(1000, "01/01/2020"));
	};

	@Test
	public void account_twoDeposits_returnTransactionLog() {
		HashMap<String, String> mockedTransaction = new HashMap<String,String>(){{
			put("Action", "Deposit");
			put("Date", "02/01/2020");
			put("Amount", "2000");
		}};
		mockedLog.add(mockedTransaction);
		assertEquals(2, mockedLog.size());
		test.deposit(1000, "01/01/2020");
		assertEquals(mockedLog, test.deposit(1000, "02/01/2020"));
	}
	
	@Test
	public void account_oneDepositOneWithdraw_returnTransactionLog() {
		HashMap<String, String> mockedTransaction = new HashMap<String, String>(){{
			put("Action", "Withdraw");
			put("Date", "02/01/2020");
			put("Amount", "500");
		}};
		mockedLog.add(mockedTransaction);
		assertEquals(2, mockedLog.size());
		test.withdraw(500, "02/01/2020");
		assertEquals(mockedLog, test.withdraw(500, "02/01/2020"));
	}
}
