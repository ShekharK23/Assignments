package L1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Problem {

	public static void main(String[] args) {
		
//		Consumer<String> con = new Consumer<String>() {
//
//			@Override
//			public void accept(String str) {
//				String t = str + "---- CG\n";
//				System.out.println(t);
//			}
//		};
		
		System.out.println("-----Problem 1 - Consumer Interface-----\n");
		Consumer<String> con = (str) -> {
			String t = str + "---- CG\n";
			System.out.println(t);
		};
		
		String arr[] = {"Sanket","Shekhar","Pranay","Pratyush","Chetan"};
		for (String str : arr) {
			con.accept(str);
		}
		
		System.out.println("\n-----Problem 2 - Predicate Interface -----\n");
		String s = "S";
		Predicate<String> pred = (str) -> {
			if (str.startsWith(s)){
				return true;
			}
			return false;
		};
		
		String arr1[] = {"Sanket","Shekhar","Pranay","Pratyush","Chetan"};
		for (String t : arr1) {
			if (pred.test(t)) {
				System.out.println(t);
			}
		}
		
		System.out.println("\n-----Problem 3 - Comparator Interface -----\n");
		List<Integer> num = new ArrayList<>();
		num.add(5);
		num.add(1);
		num.add(3);
		num.add(2);
		
		Comparator<Integer> com = (num1, num2) -> num1.compareTo(num2);
		num.sort(com);
		System.out.println(num);
	}
}
