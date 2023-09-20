package problem2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import problem1.Account;

public class AccountPolicyDB {

	Map<Integer, Account> accountMap = new HashMap<>();
	List<AccountPolicy> allPolicies = new ArrayList<>();
	
	public Map<Integer, Account> openNewAccount() {
		
		AccountPolicy p1 = new AccountPolicy(101, "Bajaj", 10000, 200000);
		AccountPolicy p2 = new AccountPolicy(102, "ICICI", 20000, 300000);
		AccountPolicy p3 = new AccountPolicy(103, "NewInsurance", 6000, 100000);
		AccountPolicy p4 = new AccountPolicy(500, "SBI", 25000, 400000);
		
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
		
		return accountMap;
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
}
