package problem1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

public class MainAppAccount {
	public static void main(String[] args) {
		
		Map<Integer, Account> accountMap = new HashMap<>();

		AccountPolicy p1 = new AccountPolicy(101, "Bajaj", 10000, 200000);
		AccountPolicy p2 = new AccountPolicy(102, "ICICI", 20000, 300000);
		AccountPolicy p3 = new AccountPolicy(103, "NewInsurance", 6000, 100000);
		AccountPolicy p4 = new AccountPolicy(500, "SBI", 25000, 400000);


		List<AccountPolicy> allPolicies = new ArrayList<>();
		allPolicies.add(p1);
		allPolicies.add(p2);
		allPolicies.add(p3);
		allPolicies.add(p4);

		List<AccountPolicy> pA1 = new ArrayList<>();
		pA1.add(p1);

		List<AccountPolicy> pA2 = new ArrayList<>();
		pA2.add(p2);

		List<AccountPolicy> pA3 = new ArrayList<>();
		pA3.add(p3);

		List<AccountPolicy> pA4 = new ArrayList<>();
		pA4.add(p4);

		Account a1 = new Account(1, "Sanket", 20000, "Islampur", pA1);
		Account a2 = new Account(2, "Shekhar", 10000, "Satara", pA2);
		Account a3 = new Account(3, "Pranay", 30000, "Nagpur", pA3);
		Account a4 = new Account(4, "Pratyush", 40000, "Nagpur", pA4);
		Account a5 = new Account(5, "Shubham", 50000, "Mumbai", pA1);
		Account a6 = new Account(6, "Chetan", 60000, "Solapur", pA3);

		accountMap.put(a1.getAccountNumber(), a1);
		accountMap.put(a2.getAccountNumber(), a2);
		accountMap.put(a3.getAccountNumber(), a3);
		accountMap.put(a4.getAccountNumber(), a4);
		accountMap.put(a5.getAccountNumber(), a5);
		accountMap.put(a6.getAccountNumber(), a6);


		MainAppAccount app = new MainAppAccount();
		Map<String, List<Account>> locationMap = new HashMap<>();
		Map<String, List<Account>> policyMap = new HashMap<>();
		Map<Integer[],List<Account>> balanceRangeMap = new LinkedHashMap<>();

		Iterator<Entry<Integer,Account>> iterate = accountMap.entrySet().iterator();

		while(iterate.hasNext()) {
			Account acc = iterate.next().getValue();
			String location = acc.getLocation();
			locationMap.put(location, app.filterAccounts(accountMap, location));
		}

		int j = 0;
		for(int i = 10000; i < 100000; i+=10000) {
			Integer arr[] = {i,j};
			balanceRangeMap.put(arr, app.filterAccountsOnBalance(accountMap, j, i));
			j += 10000;
		}

		for(Map.Entry<String,List<Account>> entry : locationMap.entrySet()) {
			Iterator<Account> iter = entry.getValue().iterator();
			System.out.println(entry.getKey()+"----------------");
			while(iter.hasNext()) {
				Account a = iter.next();
				System.out.println(" Account Id: "+a.getAccountNumber()+" AccountHolderName: "+a.getAccountHolderName()+" BankBalance: "+ a.getBalance()+" Location: "+a.getLocation());
			}

		}

		System.out.println(" ");
		System.out.println(" ");
		System.out.println("-----------------------------------------------------------------");
		System.out.println(" ");
		for(Map.Entry<Integer[],List<Account>> entry : balanceRangeMap.entrySet()) {
//			System.out.println(entry.getKey());
			Iterator<Account> iter = entry.getValue().iterator();
			System.out.println("Balance Range: "+entry.getKey()[1]+" to "+entry.getKey()[0]+"----------------");
			while(iter.hasNext()) {
				Account a = iter.next();
				System.out.println(" Account Id: "+a.getAccountNumber()+" AccountHolderName: "+a.getAccountHolderName()+" BankBalance: "+ a.getBalance()+" Location: "+a.getLocation());
			}

		}
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("All details using account id------------------------------------------------------");
		app.getAccountDetailsByAccNo(accountMap, 123);

		System.out.println(" ");
		System.out.println(" ");
		System.out.println("All accounts using policy name------------------------------------------------------");
		app.getAccountDetailsByPolicyName(accountMap, "Bajaj");

		System.out.println(" ");
		System.out.println(" ");
		System.out.println("All accounts using policy number------------------------------------------------------");
		app.getAccountDetailsByPolicyNumber(accountMap, 24635);

		System.out.println(" ");
		System.out.println(" ");
		System.out.println("All accounts which have no policy------------------------------------------------------");
		app.getAccountDetailsByNoPolicy(accountMap);

		System.out.println(" ");
		System.out.println(" ");
		System.out.println("Enter the minimum sum assured: ");
		Scanner sc = new Scanner(System.in);
		int amount = sc.nextInt();
		System.out.println("accounts with more than minimum sum assured policies are --------------------------");
		System.out.println(" ");
		app.getBySumAssured(accountMap, amount);

		System.out.println(" ");
		System.out.println(" ");
		System.out.println("Enter the maximum premium value: ");
		Scanner s = new Scanner(System.in);
		int premium = s.nextInt();
		System.out.println("accounts with less than the maximum premium policies are --------------------------");
		System.out.println(" ");
		app.getByLowPremium(accountMap, premium);

		System.out.println(" ");
		System.out.println(" ");
		System.out.println("Enter the location: ");
		Scanner scan = new Scanner(System.in);
		String policyLoc = scan.nextLine();
		System.out.println("accounts with policies in "+ policyLoc +" are --------------------------");
		System.out.println(" ");
		app.filterAccountsOnLocAndPolicy(accountMap, policyLoc);
		System.out.println(" ");
		System.out.println(" ");

		for(AccountPolicy p: allPolicies){
			policyMap.put(p.getPolicyName(), app.filterAccountsByPolicyName(accountMap, p.getPolicyName()));
		}

		for(Map.Entry<String,List<Account>> entry : policyMap.entrySet()) {
//			System.out.println(entry.getKey());
			Iterator<Account> iter = entry.getValue().iterator();
			System.out.println("Policy name: "+entry.getKey()+"-------------------");
			System.out.println(" ");
			while(iter.hasNext()) {
				Account a = iter.next();
				System.out.println(" Account Id: "+a.getAccountNumber()+" AccountHolderName: "+a.getAccountHolderName()+" BankBalance: "+ a.getBalance()+" Location: "+a.getLocation());
			}
			System.out.println(" ");
		}

	}
	public List<Account> filterAccounts(Map<Integer,Account> accountMap, String loc) {
		Iterator<Entry<Integer, Account>> itr = accountMap.entrySet().iterator();
		ArrayList<Account> sameLocAccounts = new ArrayList<>();
//		for(Map.Entry<Integer, Account> entry : accountMap.entrySet()) {
//			if(entry.getValue().getLocation().equals(loc)) {
//				System.out.println("accID "+ entry.getKey()+" acc holder name "+ entry.getValue().getAccountHolderName()+" location "+entry.getValue().getLocation());
//			}
//		}
		while(itr.hasNext()) {
			Account a = itr.next().getValue();
			String location = a.getLocation();
			if(location.equals(loc)) {
				sameLocAccounts.add(a);
			}
		}
		return sameLocAccounts;
	}

	public List<Account> filterAccountsOnBalance(Map<Integer,Account> accountMap, int min, int max) {
		Iterator<Entry<Integer, Account>> itr = accountMap.entrySet().iterator();
		ArrayList<Account> sameBalanceRangeAccounts = new ArrayList<>();
//		for(Map.Entry<Integer, Account> entry : accountMap.entrySet()) {
//			if(entry.getValue().getLocation().equals(loc)) {
//				System.out.println("accID "+ entry.getKey()+" acc holder name "+ entry.getValue().getAccountHolderName()+" location "+entry.getValue().getLocation());
//			}
//		}
		while(itr.hasNext()) {
			Account a = itr.next().getValue();
			int balance = a.getBalance();
			if(balance > min && balance <= max ) {
				sameBalanceRangeAccounts.add(a);
//				System.out.println(location);
			}
		}
		return sameBalanceRangeAccounts;
	}

	public void getAccountDetailsByAccNo(Map<Integer,Account> accountMap,int accNum) {
		for(Entry e: accountMap.entrySet()) {
			if((int)e.getKey()==accNum) {
				if(e.getValue() instanceof Account) {
					Account ac = (Account)e.getValue();
					System.out.println(ac);
					if(ac.getPolicy().size()!=0) {
					for(AccountPolicy p: ac.getPolicy()) {
						System.out.println("Premium: "+ p.getPremiumAmount() + " PolicyID: "+p.getPolicyNumber()+" PolicyName: "+p.getPolicyName()+" PolicySum: "+p.getSumAssuredAmount());
					}
					}
					else {
						System.out.println("No policies attached");
					}
				}
			}
		}
	}

	public void getAccountDetailsByPolicyName(Map<Integer,Account> accountMap,String policyName) {
		for(Entry e: accountMap.entrySet()) {
			if(e.getValue() instanceof Account) {
				Account ac = (Account)e.getValue();
				for(AccountPolicy p: ac.getPolicy()) {
					if(p.getPolicyName()==policyName) {
						System.out.println(ac);
						System.out.println("Premium: "+ p.getPremiumAmount() + " PolicyID: "+p.getPolicyNumber()+" PolicyName: "+p.getPolicyName()+" PolicySum: "+p.getSumAssuredAmount());
					}
				}
			}
		}
	}

	public void getAccountDetailsByPolicyNumber(Map<Integer,Account> accountMap,int policyNumber) {
		for(Entry e: accountMap.entrySet()) {
			if(e.getValue() instanceof Account) {
				Account ac = (Account)e.getValue();
				for(AccountPolicy p: ac.getPolicy()) {
					if(p.getPolicyNumber()==policyNumber) {
						System.out.println(ac);
						System.out.println("Premium: "+ p.getPremiumAmount() + " PolicyID: "+p.getPolicyNumber()+" PolicyName: "+p.getPolicyName()+" PolicySum: "+p.getSumAssuredAmount());
					}
				}
			}
		}
	}

	public void getAccountDetailsByNoPolicy(Map<Integer,Account> accountMap) {
		for(Entry e: accountMap.entrySet()) {
			if(e.getValue() instanceof Account) {
				Account ac = (Account)e.getValue();
				if(ac.getPolicy().size()==0) {
					System.out.println(ac);		
					System.out.println("No Policy Attached");}
				}
		}
	}

	public void getBySumAssured(Map<Integer,Account> accountMap,int amount) {
		for(Entry e: accountMap.entrySet()) {
			if(e.getValue() instanceof Account) {
				Account acc = (Account)e.getValue();
				for(AccountPolicy p: acc.getPolicy()) {
					if(p.getSumAssuredAmount()>amount) {
						System.out.println(acc);
						System.out.println("Premium: "+ p.getPremiumAmount() + " PolicyID: "+p.getPolicyNumber()+" PolicyName: "+p.getPolicyName()+" PolicySum: "+p.getSumAssuredAmount());
					}
				}
			}
		}
	}

	public void getByLowPremium(Map<Integer,Account> accountMap,int amount) {
		for(Entry e: accountMap.entrySet()) {
			if(e.getValue() instanceof Account) {
				Account acc = (Account)e.getValue();
				for(AccountPolicy p: acc.getPolicy()) {
					if(p.getPremiumAmount()<amount) {
						System.out.println(acc);
						System.out.println("Premium: "+ p.getPremiumAmount() + " PolicyID: "+p.getPolicyNumber()+" PolicyName: "+p.getPolicyName()+" PolicySum: "+p.getSumAssuredAmount());
					}
				}
			}
		}
	}

	public void filterAccountsOnLocAndPolicy(Map<Integer,Account> accountMap, String loc) {
		Iterator<Entry<Integer, Account>> itr = accountMap.entrySet().iterator();
		ArrayList<Account> sameLocAccounts = new ArrayList<>();
		while(itr.hasNext()) {
			Account a = itr.next().getValue();
			String location = a.getLocation();
			if(location.equals(loc)&& a.getPolicy().size()!=0) {
				System.out.println(a);
			}
		}
	}

	public List<Account> filterAccountsByPolicyName(Map<Integer,Account> accountMap, String policyName) {
		Iterator<Entry<Integer, Account>> itr = accountMap.entrySet().iterator();
		ArrayList<Account> samePolicyNameAccounts = new ArrayList<>();
		while(itr.hasNext()) {
			Account a = itr.next().getValue();
			if(a.getPolicy().size()!=0) {
				for(AccountPolicy p: a.getPolicy()) {
					if(p.getPolicyName().equals(policyName)) {
					samePolicyNameAccounts.add(a);
					}
				}
			}
		}
		return samePolicyNameAccounts;
	}
}
