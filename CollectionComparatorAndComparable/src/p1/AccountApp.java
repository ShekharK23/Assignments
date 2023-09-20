package p1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

public class AccountApp {

	public static void main(String[] args) {
		
		TreeSet<Account> allAccounts = new TreeSet<>();
		
		Account a1 = new Account(1, "Sanket", 20000, "Islampur");
		Account a2 = new Account(2, "Shekhar", 10000, "Satara");
		Account a3 = new Account(3, "Pranay", 30000, "Nagpur");
		Account a4 = new Account(4, "Pratyush", 40000, "Nagpur");
		Account a5 = new Account(5, "Shubham", 50000, "Mumbai");
		Account a6 = new Account(6, "Chetan", 60000, "Solapur");
		
		
		allAccounts.add(a1);
		allAccounts.add(a2);
		allAccounts.add(a3);
		allAccounts.add(a4);
		allAccounts.add(a5);
		allAccounts.add(a6);
		
		System.out.println("---  Account Class in Treeset  ----------");
		for (Account a : allAccounts) {
			System.out.println(a);
		}
	
		System.out.println("\n---  Account Balance (High to Low)  ----------");
		getAccountBalanceHighToLow(allAccounts);
		
		System.out.println("\n---  Account Balance (Low to High)  ----------");
		getAccountBalanceLowToHigh(allAccounts);

		System.out.println("\n---  Account Location  ----------");
		getAccountSortByLocation(allAccounts);

	}
	

	
	public static void getAccountBalanceHighToLow(TreeSet<Account> allAccounts)
	{
		List<Account> tempList = new ArrayList<>();
		tempList.addAll(allAccounts);

		AccountBalanceHighToLow sortCode = new AccountBalanceHighToLow();
		
		Collections.sort(tempList, sortCode);
		
		for (Account a : tempList) {
			System.out.println(a);
		}
		 
	}
	
	public static void getAccountBalanceLowToHigh(TreeSet<Account> allAccounts)
	{
		List<Account> tempList = new ArrayList<>();
		tempList.addAll(allAccounts);

		AccountBalanceLowToHigh sortCode = new AccountBalanceLowToHigh();
		
		Collections.sort(tempList, sortCode);
		
		for (Account a : tempList) {
			System.out.println(a);
		}
		 
	}
	
	public static void getAccountSortByLocation(TreeSet<Account> allAccounts)
	{
		List<Account> tempList1 = new ArrayList<>();
		tempList1.addAll(allAccounts);
		
		Collections.sort(tempList1);
		
		for (Account a : tempList1) {
			System.out.println(a);
		}
		 
	}
	
}//end class
