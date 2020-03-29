package testing;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import bankSystem.Account;
import bankSystem.Statement;
import bankSystem.TransactionHistory;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class PrintStatementTest {
	
	private static Statement test;
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	private final TransactionHistory transactionHistory = new TransactionHistory();
	private final Account account = new Account(transactionHistory);
	
	//Following the 'AAA' pattern Arrange, Action, Assert
	
	@Before
	public void setUpStreams() {
		//Arranging 
		System.setOut(new PrintStream(outContent));
		test = new Statement();
	}
	
	@After
	public void restoreStreams() {
		System.setOut(originalOut);
	}
	
	@Test
	public void printStatement_blankStatement_defaultStatement() {
		 //Action
		test.printStatement(transactionHistory);
		 //Assert
		assertEquals("Date || Credit || Debit || Balance", outContent.toString());
	}
	
	@Test
	public void printStatement_oneDeposit_correctStatement() {
		account.deposit(1000, "01/01/2020");
		test.printStatement(transactionHistory);
		assertEquals("Date || Credit || Debit || Balance\n01/01/2020 || 1000.00 || || 1000.00", outContent.toString());
	}

}
