package Problem2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AccountDB {

	Map<Integer, Account> allMapAccounts = new HashMap<>();
	
	public int openNewAccount(Account acc) {
		allMapAccounts.put(acc.getAccountNumber(),acc);
		return acc.getAccountNumber();
	}
	
	public List<Account> getAccountBasedOnBalanceRange(int r1,int r2) {
		List<Account> basedOnRange = new LinkedList<>();
		for (Map.Entry<Integer, Account> entry: allMapAccounts.entrySet()) {
			Account a = entry.getValue();
			if (a.getBalance() >= r1 && a.getBalance()<= r2) {
				basedOnRange.add(a);
			}
		}
		return basedOnRange;
	}
	
	public Account getAccountByNumber (int number){
		for (Map.Entry<Integer, Account> entry: allMapAccounts.entrySet()) {
			int key = entry.getKey();
			Account a = entry.getValue();
			if (key == number) {
				return a;
			}
		}
		return null;
	}
	
	public void getAccountsByLocation(String s){
		List<Account> basedOnLocation = new ArrayList<>();
		Map<String, List<Account>> basedOnLocationMap = new HashMap<>();
		for (Map.Entry<Integer, Account> entry: allMapAccounts.entrySet()) {
			Account a = entry.getValue();
			
			if (a.getLocation().equals(s)) {
				basedOnLocation.add(a);
			}	
		}
		basedOnLocationMap.put(s,basedOnLocation);
		System.out.println(basedOnLocationMap);
	}

	public Map<Integer, Account> getAllAccounts() {
		return allMapAccounts;
	}
}
