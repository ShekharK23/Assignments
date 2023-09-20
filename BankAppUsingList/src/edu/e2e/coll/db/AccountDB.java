package edu.e2e.coll.db;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import edu.e2e.coll.exception.LowBalanceException;
import edu.e2e.coll.model.Account;

public class AccountDB {

	List<Account> allAccounts = new ArrayList<>();
	
	public int openNewAccount(Account acc) {
		boolean status = allAccounts.add(acc);
		return (status?acc.getAccountNumber():-1);
	}
	
	public List<Account> getAccountBasedOnBalanceRange(int r1,int r2) {
		List<Account> basedOnRange = new ArrayList<>();
		for (Account a : allAccounts) {
			if (a.getBalance() >= r1 && a.getBalance() <= r2) {
				basedOnRange.add(a);
			}
		}
		return basedOnRange;
	}
	
	public Account getAccountByNumber (int number){
		for (Account a : allAccounts) {
			if (a.getAccountNumber()== number) {
				return a;
			}
		}
		return null;
	}
	
	public List<Account> getAccountsByLocation(String s){
		List<Account> basedOnLocation = new ArrayList<>();
		for (Account a : allAccounts) {
			if (a.getLocation().equals(s)) {
				basedOnLocation.add(a);
			}
		}
		return basedOnLocation;
	}
	
	public Account insertAmount(int accNum, int amt) {
		for (Account a : allAccounts) {
			if (a.getAccountNumber() == accNum) {
				a.setBalance(a.getBalance()+amt);
				return a;
			}
		}
		return null;
	}
	
	public Account withdrawAmount(int accNum, int amt) throws LowBalanceException {
		for (Account a : allAccounts) {
			if (a.getAccountNumber() == accNum) {
				if (a.getBalance() >= 5000) {
					a.setBalance(a.getBalance()-amt);
					return a;
				} else {
					throw new LowBalanceException();
				}
			}
		}
		return null;
	}
	
	
	public String transferAmount(int accNumSource,int accNumTarget, int amt) throws LowBalanceException 
	{
		
		boolean isSrcAccountFound = false;
		boolean isTargetAccountFound = false;
		
		Account srcAccount = null;
		Account targetAccount = null;
		
		
		for (Account a : allAccounts) {
			if (a.getAccountNumber() == accNumSource) {
				isSrcAccountFound = true;
				srcAccount = a;
				
				if(srcAccount.getBalance()-amt<5000)
				{
					throw new LowBalanceException();
				}
				
			}
			if (a.getAccountNumber() == accNumTarget) {
				isTargetAccountFound = true;
				targetAccount = a;
				
			}
			
			if(isSrcAccountFound && isTargetAccountFound)
			{
				int amountToTransfer = amt;
				int srcBalance = srcAccount.getBalance();
				
				int tragetBalance = targetAccount.getBalance();
				
				srcAccount.setBalance(srcBalance-amountToTransfer);
				targetAccount.setBalance(tragetBalance+amountToTransfer);
				
				return "Amount transfered UPI-ID"+new Random().nextInt(100000);
			}
		}//end of forloop
		
		if(!isSrcAccountFound)
		{
			return "Src Account Id is Wrong";
		}
		else if(!isTargetAccountFound)
		{
			return "Target Account Id is Wrong";
		}
		else return null;
		
		
	}//end of t/f funds
	
	
	
	
	public Account transferAmount_old(int accNumSource,int accNumTarget, int amt) throws LowBalanceException {
		for (Account a : allAccounts) {
			if (a.getAccountNumber() == accNumSource) {
				if (a.getBalance() >= 5000) {
					a.setBalance(a.getBalance()- amt);
					return a;
				} else {
					throw new LowBalanceException();
				}
			}
		}
		for (Account a : allAccounts) {
			if (a.getAccountNumber() == accNumTarget) {
				a.setBalance(a.getBalance()+ amt);
				return a;
			}
		}
		return null;
	}
	
	public List<Account> getAllAccounts() {
		return allAccounts;
	}
}
