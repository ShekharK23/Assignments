package usingTreeMapexception;

public class Food implements Comparable<Food>{

	private String name;
	private int price;
	private String category;

	public Food() {
		super();
	}

	public Food(String name, int price, String category) {
		super();
		this.name = name;
		this.price = price;
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public int hashCode() {
		return category.length()+name.length()-price;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Food)
		{
			Food f = (Food)obj;
			boolean a = f.category.equals(this.getCategory());
			boolean b = f.name.equals(this.getName());
			boolean c = f.price ==this.getPrice();
			return a && b && c;
		}
		else
		{
			return false;
		}
	}

	@Override
	public String toString() {
		return "Food [name=" + name + ", price=" + price + ", category=" + category + "]";
	}

	@Override
	public int compareTo(Food f) {
		return this.getName().compareTo(f.getName());
	}
	
}
