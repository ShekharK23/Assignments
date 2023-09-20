package edu.e2e.coll.service;

import java.util.List;

import edu.e2e.coll.db.AccountDB;
import edu.e2e.coll.exception.LowBalanceException;
import edu.e2e.coll.model.Account;

public class AccountServer {

	private AccountDB db;

	public AccountServer() {
		db = new AccountDB();
	}
	
	public String openNewAccount(Account acc) {
		int fromDB = db.openNewAccount(acc);
		if (fromDB != -1) {
			return "Account Created - " + acc;
		}else {
			return "ERROR !!!";
		}
	}
	
	public List<Account> getAccountBasedOnBalanceRange(int r1,int r2){
		return db.getAccountBasedOnBalanceRange(r1, r2);
	}
	
	public Account getAccountByNumber (int number) {
		return db.getAccountByNumber(number);
	}
	
	public List<Account> getAccountsByLocation(String s){
		return db.getAccountsByLocation(s);
	}
	
	public Account insertAmount(int accNum, int amt) {
		return db.insertAmount(accNum, amt);
	}
	
	public Account withdrawAmount(int accNum, int amt) throws LowBalanceException {
		return db.withdrawAmount(accNum, amt);
	}
	
	public String transferAmount(int accNumSource,int accNumTarget, int amt) throws LowBalanceException {
		return db.transferAmount(accNumSource, accNumTarget, amt);
	}
	
	public List<Account> getAllAccounts(){
		return db.getAllAccounts();
	}
}
