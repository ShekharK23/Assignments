package usingTreeSet;

import java.util.Comparator;

public class FoodSortLowToHigh implements Comparator<Food>{

	@Override
	public int compare(Food o1, Food o2) {
		return o1.getPrice() - o2.getPrice();
	}

}
