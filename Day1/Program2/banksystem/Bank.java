package banksystem;

import java.util.ArrayList;

public class Bank {
	private ArrayList<Account>accounts;
	
	public Bank() {
		super();
		this.accounts = new ArrayList<>();
	}
	
	public void addAccount(Account account) {
		if(findAccount(account.getAccountNumber())== null){
			accounts.add(account);
			System.out.println("Account added: " + account.getAccountHolderName());
		}
		else {
			System.out.println("Account with number already exists.");
		}
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
	
	private Account findAccount(String  accountNumber) {
		for(Account account : accounts) {
			if(account.getAccountNumber().equals(accountNumber)) {
				return account;
			}
		}
		return null;
	}

	

	
}
