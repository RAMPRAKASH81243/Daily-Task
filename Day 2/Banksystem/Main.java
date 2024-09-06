package banksystem;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Bank bank = new Bank();
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("\nBanking System Menu");
			System.out.println("1. Add Account \n2. Remove Account \n3. Deposit Money \n4. Withdraw Money \n5. Display All Accounts \n6. Search For an account \n7. Display Accounts by Account Holder Name \n8. Exit");	
			System.out.println("Choose an option: ");
			int choice = sc.nextInt();
			
			switch (choice) {
			case 1:// Add Account
				System.out.println("Enter Account Holder Name: ");
				String accountHolderName = sc.next();
				System.out.println("Enter Initial Balance: ");
				double initialBalance = sc.nextDouble();
				bank.addAccount(accountHolderName, initialBalance);
				break;
			case 2:// Remove Account	
				System.out.println("Enter Account Number to Remove: ");
				String removeAccountNumber = sc.next();
				bank.removeAccount(removeAccountNumber);
				break;
			case 3://Deposit Money
				System.out.println("Enter the Account number: ");
				String depositAccountNumber = sc.next();
				System.out.println("Enter Amount to Deposit: ");
				double depositAmount = sc.nextDouble();
				bank.depositToAccount(depositAccountNumber,depositAmount);
				break;
			case 4: //withdraw Money
				System.out.println("Enter the Account number: ");
				String withdrawAccountNumber = sc.next();
				System.out.println("Enter Amount to Withdraw: ");
				double withdrawAmount = sc.nextDouble();
				bank.withdrawFromAccount(withdrawAccountNumber, withdrawAmount);
				break;
			case 5:// Display all Accounts
				bank.displayAllAccounts();
				break;
			case 6:
				System.out.println("Enter the Account number: ");
				String searchAccountNumber = sc.next();
				bank.searchAccount(searchAccountNumber);
				break;
			case 7:
				System.out.println("Enter the Account Holder Name: ");
				String searchHolderName = sc.next();
				bank.displayAccountByHolderName(searchHolderName);
				break;
			case 8: // Exit
				System.out.println("Exiting Banking System.");
				sc.close();
				System.exit(0);
				break;
			default:
				System.out.println("Invaid option! Please choose a vaild option.");
			}
		}
 }
}
