package testing;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import bankSystem.statement;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class printStatementTest {
	
	private static statement test;
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	
	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
		test = new statement();
	}
	
	@After
	public void restoreStreams() {
		System.setOut(originalOut);
	}
	
	@Test
	public void test_for_printing_default_blank_statement() {
		test.printStatement();
		assertEquals("Date || Credit || Debit || Balance\n", outContent.toString());
	}

}
