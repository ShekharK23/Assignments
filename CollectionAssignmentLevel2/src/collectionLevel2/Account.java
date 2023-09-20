package problem1;

import java.util.ArrayList;
import java.util.List;

public class Account {

	private int accountNumber;
	private String accountHolderName;
	private int balance;
	private String location;
	private List<AccountPolicy> policy = new ArrayList<>();
	
	public Account() {
	}

	public Account(int accountNumber, String accountHolderName, int balance, String location,List<AccountPolicy> policy) {
		this.accountNumber = accountNumber;
		this.accountHolderName = accountHolderName;
		this.balance = balance;
		this.location = location;
		this.policy = policy;
	}

	public List<AccountPolicy> getPolicy() {
		return policy;
	}

	public void setPolicy(List<AccountPolicy> policy) {
		this.policy = policy;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public int hashCode() {
		return (int) (Math.random()*1000);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Account) {
			Account acc = (Account) obj;
			boolean a1 = this.accountHolderName.equals(acc.accountHolderName);
			boolean a2 = this.accountNumber == acc.accountNumber;
			boolean a3 = this.balance == acc.balance;
			boolean a4 = this.location.equals(acc.location);
			return a1 && a2 && a3 && a4;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", accountHolderName=" + accountHolderName + ", balance="
				+ balance + ", location=" + location + "]";
	}
	
}
