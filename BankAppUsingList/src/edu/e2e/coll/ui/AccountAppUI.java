package edu.e2e.coll.ui;

import java.util.List;

import java.util.Random;
import java.util.Scanner;

import edu.e2e.coll.model.Account;
import edu.e2e.coll.service.AccountServer;

public class AccountAppUI {
	
	Scanner sc = new Scanner(System.in);
	Scanner scan = new Scanner(System.in);
	AccountServer server;
	
	
	public AccountAppUI() {
		server = new AccountServer();
	}

	public static void main(String[] args) {
		AccountAppUI app = new AccountAppUI();
		while(true) {
			System.out.println("------------- Operations To Perform --------------------\n");
			System.out.println("1. Create New Account ");
			System.out.println("2. Deposit Amount to Acount ");
			System.out.println("3. Withdraw Amount from Account ");
			System.out.println("4. Transfer Amount to Account ");
			System.out.println("5. Search Account By Balance Range ");
			System.out.println("6. Search Account By Account Number ");
			System.out.println("7. Search Account By Location");
			System.out.println("8. Display All Accounts ");
			System.out.println("0. Exit \n");
			System.out.println("------------- Enter Option -----------------------------");
			
			switch (new Scanner(System.in).nextInt()) {
			case 1:
				app.fillCreateAccountForm();
				break;
			case 2:
				app.depositAmount();
				break;
			
			case 3:
				app.withdrawAmount();
				break;
				
			case 4:
				app.transferAmount();
				break;
				
			case 5:
				app.getAccountByBalanceRange();
				break;
				
			case 6:
				app.getAccByNum();
				break;
				
			case 7:
				app.getAccountByUsingLocation();
				break;
			
			case 8:
				app.getAllAccounts();
				break;
				
			case 0:
				System.exit(0);
				break;
				
			default:
				break;
			}
		}
	}
	
	
	public void fillCreateAccountForm() {
		int accountNumber = new Random().nextInt(1000);
		
		System.out.println("Enter Account Holder Name - ");
		String accountHolderName = scan.nextLine();
		
		System.out.println("Enter Account Balance - ");
		int accountBalance = sc.nextInt();
		
		System.out.println("Enter Location - ");
		String accountLocation = scan.nextLine();
		
		Account a = new Account(accountNumber, accountHolderName, accountBalance, accountLocation);
		String noti = server.openNewAccount(a);
		System.out.println(noti);
	} 
	
	public void displayAccounts(Account a) {
		System.out.println("Account Number = " + a.getAccountNumber() + ", Account Holder Name = " + a.getAccountHolderName() + ", Balance = "
				+ a.getBalance() + ", Location = " + a.getLocation());
	}
	
	public void depositAmount () {
		System.out.println("Enter Account Number - ");
		int accountNum = sc.nextInt();
		
		System.out.println("Enter Amount to Deposit - ");
		int amount1 = sc.nextInt();
		
		Account a = server.insertAmount(accountNum, amount1);
		
		if (a != null) {
			System.out.println("Amount Deposited To - "+a.getAccountNumber()+" Current Balance Is - "+a.getBalance());
		} else {
			System.out.println("Account Number Not Found.");
		}
		
	}
	
	public void withdrawAmount () {
		System.out.println("Enter Account Number - ");
		int accountNum = sc.nextInt();
		
		System.out.println("Enter Amount to Withdraw - ");
		int amount1 = sc.nextInt();
		
		try {
			Account a = server.withdrawAmount(accountNum, amount1);
			if (a != null) {
				System.out.println("Amount Withdrawal Successful To - "+a.getAccountNumber()+" Current Balance Is - "+a.getBalance());
			} else {
				System.out.println("Account Number Not Found.");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	public void transferAmount () {
		System.out.println("Enter Source Account Number - ");
		int source = sc.nextInt();
		
		System.out.println("Enter Target Account Number - ");
		int target = sc.nextInt();
		
		System.out.println("Enter Amount to Transfer - ");
		int amount = sc.nextInt();
		try {
			server.transferAmount(source, target, amount);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void getAccountByBalanceRange() {
		System.out.println("Enter Balance Start Range - ");
		int source = sc.nextInt();
		
		System.out.println("Enter Balance End Range - ");
		int target = sc.nextInt();
		
		List<Account> lst = server.getAccountBasedOnBalanceRange(source, target);
		for(Account a : lst) {
			displayAccounts(a);
		}
	}
	
	public void getAccByNum() {
		System.out.println("Enter Account Number To Search - ");
		int num = sc.nextInt();
		
		Account acc = server.getAccountByNumber(num);
		if (acc != null) {
			displayAccounts(acc);
		} else {
			System.out.println("Account Not Found For Number - "+num);
		}
	}
	
	public void getAccountByUsingLocation() {
		System.out.println("Enter Location To Search Accounts - ");
		String loc = scan.nextLine();
		
		List<Account> lst = server.getAccountsByLocation(loc);
		for(Account a : lst) {
			displayAccounts(a);
		}
	}
	
	public void getAllAccounts() {
		List<Account> allAccounts = server.getAllAccounts();
		for (Account a : allAccounts) {
			displayAccounts(a);
		}	
	}
	
}
