package testing;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.mock;

import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

import bankSystem.Account;
import bankSystem.TransactionHistory;

public class AccountTest {
	
	private static Account test;
	private final PrintStream originalOut = System.out;
	public TransactionHistory transactionHistory = mock(TransactionHistory.class);
	
	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
		test = new Account(transactionHistory);
	}
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
