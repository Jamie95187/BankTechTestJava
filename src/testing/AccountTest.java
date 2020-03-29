package testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.mock;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import bankSystem.Account;
import bankSystem.TransactionHistory;

public class AccountTest {
	
	private Account test;
	private ArrayList<HashMap<String, String>> mockedLog;
//	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//	private final PrintStream originalOut = System.out;
	
	@Mock
	private TransactionHistory mockedTransactionHistory = mock(TransactionHistory.class);
	
	@Before
	public void setUpStreams() {
		test = new Account(mockedTransactionHistory);
		// Add one deposit transaction to the mockedLog
		mockedLog = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> mockedTransaction = new HashMap<String,String>(){{
			put("Action", "Deposit");
			put("Date", "01/01/2020");
			put("Amount", "1000");
		}};
		mockedLog.add(mockedTransaction);
	};
	
	@Test
	public void account_deposit_oneDeposit() {
		when(mockedTransactionHistory.getLog()).thenReturn(mockedLog);
		assertEquals(1, mockedLog.size());
		assertEquals(mockedLog, test.deposit(1000, "01/01/2020"));
	};

}
