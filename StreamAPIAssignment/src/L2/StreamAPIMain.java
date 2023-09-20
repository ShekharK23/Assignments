package L2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamAPIMain {

	static List<Account> alllist; 
	
	public static void main(String[] args) {
		
		Account a1 = new Account(1, "Sanket", 2000, "Satara");
		Account a2 = new Account(2, "Shekhar", 1000, "Satara");
		Account a3 = new Account(3, "Pranay", 30000, "Nagpur");
		Account a4 = new Account(4, "Pratyush", 4000, "Satara");
		Account a5 = new Account(5, "Shubham", 50000, "Mumbai");
		Account a6 = new Account(6, "Chetan", 6000, "Solapur");
		
		alllist = Arrays.asList(a1,a2,a3,a4,a5,a6);
		
		System.out.println("-----Printing Each Entry Using ForEach-----");
		callForEach();
		
		System.out.println("-----Accounts By Balance belove 10000------");
		List<Account> list3 = getBalanceBelow();
		list3.stream().forEach(acc->System.out.println(acc));
		
		System.out.println("-----Adding Intrest on Savings-----");
		List<Account> list2 = giveIntrestForAmmount();
		list2.stream().forEach(acc->System.out.println(acc));
		
		System.out.println("------------------Accounts By Location-----------------------------");
		getMaxAndMinByLocation();
		
	}
	
	public static void callForEach() {
		alllist.stream().forEach(acc -> System.out.println(acc));
	}
	
	public static List<Account> getBalanceBelow(){
		List<Account> outList = alllist.stream().filter(acc -> (acc.getBalance()<= 10000)).collect(Collectors.toList());
		return outList;
	}
	
	public static List<Account> giveIntrestForAmmount(){
		List<Account> a = alllist.stream().filter(acc -> (acc.getBalance()>15000))
				.map(acc -> {
			int oldBalance = acc.getBalance();
			int newBalance = (int) ((oldBalance * 0.02)+oldBalance);
			acc.setBalance(newBalance);
			return acc;
		}).collect(Collectors.toList());
		return a;
	}
	
	public static void getMaxAndMinByLocation() {
		Map<String, List<Account>> accountsByLocation = alllist.stream().collect(Collectors.groupingBy(Account::getLocation));
		accountsByLocation.forEach((Location, accountList) -> {
			Optional<Account> min = accountList.stream().min(Comparator.comparingDouble(Account::getBalance));
			Optional<Account> max = accountList.stream().max(Comparator.comparingDouble(Account::getBalance));
			System.out.println("Location - " + Location);
			min.ifPresent(min1 -> System.out.println("Minimum Balance Account - "+min));
			min.ifPresent(max1 -> System.out.println("Maximum Balance Account - "+max));
			});
	}
	
}
