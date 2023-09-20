package Problem3L1;

import java.util.LinkedList;
import java.util.List;

public class AccountDB {

	List<Account> listofAccounts = new LinkedList<>();
	
	public List<Account> openNewAccount() {
		Account a1 = new Account(101,"Shekhar",1000,"Satara");
		Account a2 = new Account(102,"Patil Saheb",200000,"Pune");
		Account a3 = new Account(103,"Pranay",1000,"Mumbai");
		
		listofAccounts.add(a1);
		listofAccounts.add(a2);
		listofAccounts.add(a3);
		
		return listofAccounts;
	}
}
