package p1;

import java.util.Comparator;

public class AccountBalanceLowToHigh implements Comparator<Account>{

	@Override
	public int compare(Account a1, Account a2) {
		return a1.getBalance()-a2.getBalance();
	}

}
