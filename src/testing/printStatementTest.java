package testing;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import bankSystem.Statement;
import bankSystem.TransactionHistory;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class PrintStatementTest {
	
	private static Statement test;
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	TransactionHistory mockTransactionHistory = new TransactionHistory();
	
	//  Following the 'AAA' pattern Arrange, Action, Assert
	
	@Before
	public void setUpStreams() {
		// Arranging 
		System.setOut(new PrintStream(outContent));
		test = new Statement();
	}
	
	@After
	public void restoreStreams() {
		System.setOut(originalOut);
	}
	
	@Test
	public void printStatement_blankStatement_defaultStatement() {
		// Action
		test.printStatement(mockTransactionHistory);
		// Assert
		assertEquals("Date || Credit || Debit || Balance", outContent.toString());
	}
	
	@Test
	public void printStatement_oneDeposit_correctStatement() {
		test.printStatement(mockTransactionHistory);
		assertEquals("Date || Credit || Debit || Balance\n01/01/2020 || 1000.00 || || 1000.00", outContent.toString());
	}

}
