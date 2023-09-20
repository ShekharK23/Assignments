package p1;

import java.util.Comparator;

public class AccountBalanceHighToLow implements Comparator<Account>
{

	@Override
	public int compare(Account a1, Account a2) {
		return a2.getBalance() - a1.getBalance();
	}
	
}