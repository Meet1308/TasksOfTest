package test;

import java.util.Scanner;

public class BankAccount {

	private String name;
	private long accountNumber;
	private long balance;

	public BankAccount(String name, long accountNumber) {
		this.name = name;
		this.accountNumber = accountNumber;
		this.balance = 0;
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

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Your name : ");
		String name = sc.nextLine();

		System.out.print("Enter your account number: ");
		long accountNumber = sc.nextLong();

		BankAccount account = new BankAccount(name, accountNumber);

		int choice;

		do {
			System.out.println("\nMenu:");
			System.out.println("1. Deposit");
			System.out.println("2. Withdraw");
			System.out.println("3. Check Balance");
			System.out.println("4. Exit");
			System.out.print("Enter your choice: ");
			choice = sc.nextInt();

			switch (choice) {
			case 1:
				System.out.print("Enter amount to deposit: ");
				long depAmount = sc.nextLong();
				account.depositAmount(depAmount);
				break;
			case 2:
				System.out.print("Enter amount to withdraw: ");
				long withAmount = sc.nextLong();
				account.withdrawAmount(withAmount);
				break;
			case 3:
				System.out.println("Your balance is: Rs." + account.getBalance());
				break;
			case 4:
				System.out.println("Exiting Banking System.");
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		} while (choice != 4);

		sc.close();
	}
}
