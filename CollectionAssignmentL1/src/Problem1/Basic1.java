package Problem1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Basic1 {

	Map<Integer, String> mapforValues = new HashMap<>();
	Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		Basic1 app = new Basic1();
		while(true) {
			System.out.println("------------- Operations To Perform --------------------\n");
			System.out.println("1. Insert Key and Value in Map ");
			System.out.println("2. Get Value by Key ");
			System.out.println("3. Display all Entities in Map ");
			System.out.println("0. Exit \n");
			System.out.println("------------- Enter Option -----------------------------");
			
			switch (new Scanner(System.in).nextInt()) {
			case 1:
				app.insertInMap();
				break;
			case 2:
				app.getValueByKey();
				break;
			
			case 3:
				app.getAllEntity();
				break;
				
			case 0:
				System.exit(0);
				break;
				
			default:
				break;
			}
		}
	}
	
	public void insertInMap(){
		
		System.out.println("Enter Integer Key to add in map - ");
		int key = Integer.parseInt(sc.nextLine());
		
		System.out.println("Enter String Value to add in map - ");
		String val = sc.nextLine();
		
		mapforValues.put(key,val);
		System.out.println("Inserted In Map.");
		
	}
	
	public void getValueByKey() {
		System.out.println("Enter Integer Key to search in map - ");
		int key = Integer.parseInt(sc.nextLine());
		
		System.out.println("Value is - "+mapforValues.get(key));
	}
	
	public void getAllEntity(){
		for (Map.Entry<Integer, String> entry : mapforValues.entrySet()) {
			int key = entry.getKey();
			String val = entry.getValue();
			System.out.println("Key - "+key+" Value - "+val);
		}
	}
}
