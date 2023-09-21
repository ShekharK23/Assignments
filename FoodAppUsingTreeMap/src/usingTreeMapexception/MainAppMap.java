package usingTreeMapexception;

import java.util.ArrayList;


import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import usingTreeMap.Food;
import usingTreeMap.Reviews;

public class MainAppMap {
	
	public static void main(String[] args) {
	
		Map<Food, List<Reviews>> allmap = new TreeMap<>();
		
		Reviews r1 = new Reviews("Pranay",4, "Taste is Nice.");
		Reviews r2 = new Reviews("sanket",1, "Taste is worst.");
		Reviews r3 = new Reviews("shekhar",2, "Food is not Fresh.");
		Reviews r4 = new Reviews("",3, "Taste is ok");
		Reviews r5 = new Reviews("pratyush",5, "Fantastic");
		
		Food f1 = new Food("Lassi", 20, "Veg");
		Food f2 = new Food("Thaali", 100, "Veg");
		Food f3 = new Food("Chicken Biryani", 150, "NonVeg");
		Food f4 = new Food("Cake", 30, "NonVeg");
		
		List<Reviews> review1 = new ArrayList<>();
		review1.add(r1);
		review1.add(r2);
		
		List<Reviews> review2 = new ArrayList<>();
		review2.add(r3);
		review2.add(r4);
		
		List<Reviews> review3 = new ArrayList<>();
		review3.add(r5);
		review3.add(r1);
		
		List<Reviews> review4 = new ArrayList<>();
		review4.add(r2);
		review4.add(r3);
		
		allmap.put(f1, review1);
		allmap.put(f2, review2);
		allmap.put(f3, review3);
		allmap.put(f4, review4);
		
		printAllInformation(allmap);
		averageRating(allmap);
		numOfReviews(allmap);
		
	}
	
	public static void printAllInformation(Map<Food, List<Reviews>> allmap) {
		allmap.forEach((food,reviews) -> {
			System.out.println("\n----------- Food - "+food.getName()+"----------\n");
			System.out.println("Price - "+food.getPrice());
			System.out.println("Category - "+food.getCategory());
			System.out.println("Reviews - ");
			for(Reviews review: reviews) {
				System.out.println("    Username - "+review.getUserName());
				try {
					if(review.getUserName()== null ||review.getUserName().isEmpty()) {
						throw new UserNameMissingException("Username Is Missing In Review.");
					}
				} catch (UserNameMissingException e) {
					System.out.println(e);
				}
				System.out.println("    Rating Points - "+review.getPoints());
				System.out.println("    Comment - "+review.getComment()+"\n");
			}
			System.out.println("-------------------------------------");
			});
	}
	
	public static void averageRating(Map<Food, List<Reviews>> allmap) {
		allmap.forEach((food,reviews) -> {
			System.out.println("\n----------- Food - "+food.getName()+"----------\n");
			float totalRating = 0;
			float avgRating = 0;
			for(Reviews review: reviews) {
				totalRating += review.getPoints();
				avgRating = totalRating / reviews.size();
			}
			System.out.println("Average Rating - "+ avgRating);
			System.out.println("-------------------------------------");
			});
	}
	
	public static void numOfReviews(Map<Food, List<Reviews>> allmap) {
		allmap.forEach((food,reviews) -> {
			System.out.println("\n----------- Food - "+food.getName()+"----------\n");
			int size = reviews.size();
			System.out.println("Reviews - "+ size);
			System.out.println("-------------------------------------");
			});
	}

}
