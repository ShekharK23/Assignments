package usingTreeSet;

import java.util.Comparator;

public class FoodSortHighToLow implements Comparator<Food> {

	@Override
	public int compare(Food o1, Food o2) {
		return o2.getPrice()- o1.getPrice();
	}

}
