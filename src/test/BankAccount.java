package test;

public class BankAccount {

	private String name;
	private long accountNumber;
	private long balance;

	public BankAccount(String name, long accountNumber) {
		this.name = name;
		this.accountNumber = accountNumber;
		this.balance = 0;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void depositAmount(long amount) {
		if (amount <= 0) {
			System.out.println("Invalid deposit amount. Please enter a Positive Amount value.");
			return;
		}
		balance += amount;
		System.out.println("Deposited Rs. " + amount + " New Balance: Rs." + balance);
	}

	public void withdrawAmount(long amount) {
		if (amount <= 0) {
			System.out.println("Invalid withdrawal amount. Please Enter Positive amount value.");
			return;
		}
		if (amount > balance) {
			System.out.println("Insufficient funds. Your balance is Rs." + balance + ".");
			return;
		}
		balance -= amount;
		System.out.println("Withdrew Rs." + amount + ". New balance: Rs." + balance);
	}

	public long getBalance() {
		return balance;
	}
}
