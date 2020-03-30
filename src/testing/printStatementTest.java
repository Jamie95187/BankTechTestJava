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
	private final String script = "Date || Credit || Debit || Balance";
	
	// Following the 'AAA' pattern Arrange, Action, Assert
	// JUnit test naming convention "MethodName_StateUnderTest_ExpectedBehavior"
	
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
		assertEquals(script, outContent.toString());
	}
	
	@Test
	public void printStatement_oneDeposit_correctStatement() {
		account.deposit(1000, "01/01/2020");
		test.printStatement(transactionHistory);
		assertEquals(script + "\n01/01/2020 || 1000.00 || || 1000.00", outContent.toString());
	}
	
	@Test
	public void printStatement_oneDepositAndOneWithdraw_correctStatement() {
		account.deposit(1000, "01/01/2020");
		account.withdraw(500, "02/01/2020");
		test.printStatement(transactionHistory);
		assertEquals(script + "\n02/01/2020 || || 500.00 || 500.00\n01/01/2020 || 1000.00 || || 1000.00", outContent.toString());
	}
	
//	@Test
//	public void printStatement_twoDepositsOneWithdraw_printAcceptanceCriteria() {
//		account.deposit(1000, "10/01/2012");
//		account.deposit(2000, "13/01/2012");
//		account.withdraw(500, "14/01/2012");
//		assertEquals(script + "\n14/01/2012 || || 500.00 || 2500.00\n13/10/2012 || 2000.00 || || 3000.00\n14/10/2012 || 1000.00 || || 1000.00", outContent.toString());
//	}

}
