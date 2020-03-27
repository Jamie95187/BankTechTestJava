package testing;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;

import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

import bankSystem.Account;

public class AccountTest {
	
	private static Account test;
	private final PrintStream originalOut = System.out;
	
	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
		test = new Account();
	}
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
