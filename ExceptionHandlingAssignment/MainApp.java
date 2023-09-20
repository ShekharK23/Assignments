package ExceptionHandlingAssignment;
import java.util.Scanner;

public class MainApp {
	
	Scanner sc = new Scanner(System.in);

	   public static void main(String[] args) {
		   MainApp app = new MainApp();
		   
		   while(true) {
				
				System.out.println("----- Select Type ------");
				System.out.println("1. Deposit");
				System.out.println("2. Withdraw");
				System.out.println("3. Check Balance");
				System.out.println("0. Exit");
				
				System.out.println("\nEnter Your Option -----");
				int opt = Integer.parseInt(app.sc.nextLine());
				
				switch (opt) {
				case 1:
					app.enterDetails("Deposit");
					break;

				case 2:
					app.enterDetails("Withdraw");
					break;
					
				case 3:
					app.enterDetails("Balance");
					break;
					
				case 0:
					System.exit(0);
					
				default:
					break;
				}
			}

			}
			
			public void enterDetails(String type) {
				System.out.println("Enter Account Number : - ");
				int num = Integer.parseInt(sc.nextLine());
				
				System.out.println("Enter Account Holder Name :- ");
				String name = sc.nextLine();
				
				System.out.println("Enter Balance :- ");
				int bal = Integer.parseInt(sc.nextLine());
				
				try {
					if(type.equals("Withdraw"))
					{
						System.out.println("Enter Ammount to Withdraw : - ");
						int wit = Integer.parseInt(sc.nextLine());
						
						Account acc = new Account(num, name, bal);
						System.out.println("Withdrawing - "+ wit +"\nNew Balance - "+acc.doWithdrawal(wit));
					}
					if(type.equals("Deposit"))
					{
						System.out.println("Enter Ammount to Withdraw : - ");
						int dep = Integer.parseInt(sc.nextLine());
						
						Account acc = new Account(num, name, bal);
						System.out.println("Depositing - "+ dep+"\nNew Balance - "+acc.doDeposit(dep));
					}
					if(type.equals("Balance")){
						Account acc = new Account(num, name, bal);
						System.out.println("Current Balance:"+acc.getBalance());
					}
				}
				catch(InsufficientFundException e) {
					System.out.println("Error:"+e.getMessage());
				}
			
		}
}

