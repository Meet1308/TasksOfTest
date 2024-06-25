package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Bank {

	private List<BankAccount> accounts;

	public Bank() {
		this.accounts = new ArrayList<BankAccount>();
	}

	public void createAccount(String name) {
		long accountNumber;
		do {
			accountNumber = generateAccountNumber();
		}while(findAccount(accountNumber) != null);
		
		BankAccount account = new BankAccount(name, accountNumber);
		accounts.add(account);
		System.out.println("Account created successfully! Your Account Number is : "+accountNumber);
	}
	
	 private int generateAccountNumber() {
		 	Random random = new Random();
	        return 10000 + random.nextInt(90000);  
	    }

	 
	public BankAccount findAccount(long accountNumber) {
		for (BankAccount acc : accounts) {
			if (acc.getAccountNumber() == accountNumber) {
				return acc;
			}
		}
		return null;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Bank bank = new Bank();

		int choice;
		do {
			System.out.println("\nMenu:");
			System.out.println("1. Create Account");
			System.out.println("2. Deposit");
			System.out.println("3. Withdraw");
			System.out.println("4. Check Balance");
			System.out.println("5. Exit");
			System.out.print("Enter your choice: ");
			choice = sc.nextInt();

			switch (choice) {
			case 1:
				System.out.print("Enter your name: ");
				String name = sc.nextLine();
				sc.nextLine(); 
				bank.createAccount(name);
				break;
				
			case 2:
				System.out.print("Enter account number for deposit: ");
				long depositAccountNumber = sc.nextLong();
				BankAccount depositAccount = bank.findAccount(depositAccountNumber);
				if (depositAccount != null) {
					System.out.print("Enter amount to deposit: ");
					long depositAmount = sc.nextLong();
					depositAccount.depositAmount(depositAmount);
				} else {
					System.out.println("Account not found!");
				}
				break;
				
			case 3:
				System.out.print("Enter account number for withdrawal: ");
				long withdrawAccountNumber = sc.nextLong();
				BankAccount withdrawAccount = bank.findAccount(withdrawAccountNumber);
				if (withdrawAccount != null) {
					System.out.print("Enter amount to withdraw: ");
					long withdrawAmount = sc.nextLong();
					withdrawAccount.withdrawAmount(withdrawAmount);
				} else {
					System.out.println("Account not found!");
				}
				break;
				
			case 4:
				System.out.print("Enter account number for balance check: ");
				long balanceAccountNumber = sc.nextLong();
				BankAccount balanceAccount = bank.findAccount(balanceAccountNumber);
				if (balanceAccount != null) {
					System.out.println("Your balance is: Rs." + balanceAccount.getBalance());
				} else {
					System.out.println("Account not found!");
				}
				break;
				
			case 5:
				System.out.println("Exiting Banking System.");
				break;
				
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		} while (choice != 5);

		sc.close();
	}
}
