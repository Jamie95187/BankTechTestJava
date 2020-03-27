package testing;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ PrintStatementTest.class, TransactionHistoryTest.class, AccountTest.class })
public class AllTests {

}
