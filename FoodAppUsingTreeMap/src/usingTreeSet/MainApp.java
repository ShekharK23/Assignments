package usingTreeSet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

public class MainApp {

	public static void main(String[] args) {
		
		TreeSet<Food> allFood = new TreeSet<>();
		
		Food f1 = new Food("Lassi", 20, "Veg");
		Food f2 = new Food("Thaali", 100, "Veg");
		Food f3 = new Food("Chicken Biryani", 150, "NonVeg");
		Food f4 = new Food("Cake", 30, "NonVeg");
		
		allFood.add(f1);
		allFood.add(f2);
		allFood.add(f3);
		allFood.add(f4);
		
		for (Food food : allFood) {
			System.out.println(food);
		}
		
		System.out.println("\n---  Food Price (High to Low)  ----------");
		getFoodsortedHighToLow(allFood);
		
		System.out.println("\n---  Food Price (Low to High)  ----------");
		getFoodsortedLowToHigh(allFood);
		
		System.out.println("\n---  Food Sort By Name  ----------");
		getFoodSortByName(allFood);
		
	}
	
	public static void getFoodsortedHighToLow(TreeSet<Food> allFood) {
		List<Food> temp = new ArrayList<>();
		temp.addAll(allFood);
		
		FoodSortHighToLow sort = new FoodSortHighToLow();
		
		Collections.sort(temp, sort);
		
		for (Food f : temp) {
			System.out.println(f);
		}
		
	}
	
	public static void getFoodsortedLowToHigh(TreeSet<Food> allFood) {
		List<Food> temp = new ArrayList<>();
		temp.addAll(allFood);
		
		FoodSortLowToHigh sort = new FoodSortLowToHigh();
		
		Collections.sort(temp, sort);
		
		for (Food f : temp) {
			System.out.println(f);
		}
		
	}
	
	public static void getFoodSortByName(TreeSet<Food> allFood)
	{
		List<Food> temp = new ArrayList<>();
		temp.addAll(allFood);
		
		Collections.sort(temp);
		
		for (Food f : temp) {
			System.out.println(f);
		}
		 
	}
}
