package banksystem;

import java.util.*;

public class Bank {
	private ArrayList<Account>accounts;
	
	public Bank() {
		super();
		this.accounts = new ArrayList<>();
	}
	
	private String generateAccountNumber() {
		int randomAccountNumber;
		do {
			randomAccountNumber = (int)(Math.random()*9000)+ 1000;
		}while(accountExists(String.valueOf(randomAccountNumber)));
		return String.valueOf(randomAccountNumber);
	}
	
	public boolean accountExists(String accountNumber) {
		return findAccount(accountNumber) != null;
	}
	
	public void addAccount(String accountHolderName,double initialBalance) {
		String newAccountNumber = generateAccountNumber();
		Account newAccount = new Account(newAccountNumber,accountHolderName,initialBalance);
		accounts.add(newAccount);
		System.out.println("Account added: " + accountHolderName +", Account Number: " + newAccountNumber);
		
	}
	
	public void removeAccount(String accountNumber) {
		Account account = findAccount(accountNumber);
		if(account != null){
			accounts.remove(account);
			System.out.println("Account removed: " + account.getAccountHolderName());
		}
		else {
			System.out.println("No account find with the given number.");
		}
	}
	
	public void depositToAccount(String accountNumber, double amount) {
		Account account = findAccount(accountNumber);
		if(account != null){
			account.deposit(amount);
		}
		else {
			System.out.println("No account find with the given number.");
		}
	}
	
	public void withdrawFromAccount(String accountNumber, double amount) {
		Account account = findAccount(accountNumber);
		if(account != null){
			account.withdraw(amount);
		}
		else {
			System.out.println("No account find with the given number.");
		}
	}
	
	public void displayAllAccounts() {
		if(accounts.isEmpty()) {
			System.out.println("No accounts in the bank.");
		}
		else {
			for(Account account : accounts) {
				System.out.println("Account Number: "+ account.getAccountNumber() + ",Account Holder: "+ account.getAccountHolderName() + ",Balance: " + account.getBalance());
			}
		}
	}
	
	public void searchAccount(String accountNumber) {
		Account account = findAccount(accountNumber);
		if(account != null){
			System.out.println("Account Number: "+ account.getAccountNumber() + ",Account Holder: "+ account.getAccountHolderName() + ",Balance: " + account.getBalance());
		}
		else {
			System.out.println("No account find with the given number.");
		}
	}
	
	public void displayAccountByHolderName(String accountHolderName) {
		boolean found = false;
		for(Account account:accounts) {
			if(account.getAccountHolderName().equalsIgnoreCase(accountHolderName)) {
				System.out.println("Account Number: "+ account.getAccountNumber() + ",Account Holder: "+ account.getAccountHolderName() + ",Balance: " + account.getBalance());
				found = true;
			}
		}
			if(!found){
				System.out.println("No account find with the given account holder name.");
			}
		}
	
	private Account findAccount(String  accountNumber) {
		for(Account account : accounts) {
			if(account.getAccountNumber().equals(accountNumber)) {
				return account;
			}
		}
		return null;
	}

	

	
}
