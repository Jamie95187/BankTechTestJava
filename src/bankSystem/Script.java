package bankSystem;

import java.util.Scanner;

public class Script {
	
	private static final TransactionHistory transactionHistory = new TransactionHistory();
	private static final Account account = new Account(transactionHistory);
	
	public static void main(String[] args) {
		int finished = -1;
//		Boolean finished = null;
		boolean validTransaction = false;
		Scanner scanner = new Scanner(System.in);
		while(finished != 1) {
			finished = 0;
			validTransaction = false;
			while(validTransaction == false) {
				validTransaction = askTransaction(scanner, validTransaction);
			}
			do {
				finished = hasFinished(scanner);
			} while(finished == 0);
		}
		scanner.close();
		Statement.printStatement(transactionHistory);
	}
	
	private static boolean askTransaction(Scanner scanner, boolean validTransaction) {
		System.out.println("Enter a transaction, either deposit or withdraw");
		String action = scanner.nextLine();
		System.out.println("Enter an amount");
		String amount = scanner.nextLine();
		String capitalizedAction = action.substring(0,1).toUpperCase()+action.substring(1).toLowerCase();
		if(capitalizedAction.compareTo("Deposit") == 0) {
			account.deposit(Integer.parseInt(amount));
			return true;
		} else if(capitalizedAction.compareTo("Withdraw") == 0) {
			account.withdraw(Integer.parseInt(amount));
			return true;
		} else {
			System.out.println("Invalid transaction");
			return false;
		}
	}
	
	private static int hasFinished(Scanner scanner) {
		System.out.println("Have you finished with your transactions?");
		String answer = scanner.nextLine();
		if(answer.toLowerCase().compareTo("yes") == 0) {
			return 1;
		} else if(answer.toLowerCase().compareTo("no") == 0) {
			return -1;
		} else {
			System.out.println("Invalid answer");
		}
		return 0;
	}
	
}
