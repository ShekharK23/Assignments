package ExceptionHandlingAssignment;

public class Account {

	private int accountNumber;
	private String accountHolderName;
	private int balance;

	public Account(int accountNumber, String accountHolderName, int balance) {
		super();
		this.accountNumber = accountNumber;
		this.accountHolderName = accountHolderName;
		this.balance = balance;
		}

	public int getBalance() {
		return balance;
	}

	public int doDeposit(int ammount) {
	   if(ammount>0) {
		   balance += ammount;
	   	}
	   return balance;
	}

	public int doWithdrawal(int ammount) throws InsufficientFundException{
	   if(ammount<=0) {
		   throw new IllegalArgumentException("Withdrawal ammount must be greater that zero.");
	   }
	   if(balance-ammount<5000) {
		   throw new InsufficientFundException("Cannot withdraw "+ammount+" as balance is only "+balance);
	   }
	   balance -= ammount;
	   return balance;
	}
}
