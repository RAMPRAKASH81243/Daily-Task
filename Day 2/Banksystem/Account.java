package banksystem;

public class Account {
	
	private String accountNumber;
	private String accountHolderName;
	private double balance;

	public Account(String accountNumber, String accountHolderName, double initialBalance) {
		super();
		this.accountNumber = accountNumber;
		this.accountHolderName = accountHolderName;
		this.balance = initialBalance;
	}
	
	public void deposit(double amount) {
		if(amount > 0) {
			balance += amount;
			System.out.println("Deposited " + amount +". New balance: "+ balance);
		}
		else {
			System.out.println("Invaild deposit amount");
		}
	}
	
	public void withdraw(double amount) {
		if(amount > 0 && amount <= balance) {
			balance -= amount;
			System.out.println("Withdrew " + amount +". New balance: "+ balance);
		}
		else {
			System.out.println("Invaild or insufficient funds for withdrawal.");
		}
	}
	public String getAccountNumber() {
		return accountNumber;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public double getBalance() {
		return balance;
	}
}
