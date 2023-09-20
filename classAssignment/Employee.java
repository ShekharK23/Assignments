package classAssignment;

public class Employee {

	private float hr_pay;
	private int hr_reg;
	private int hr_over;
	
	public Employee() {
	}

	public Employee(float hr_pay, int hr_reg, int hr_over) {
		super();
		this.hr_pay = hr_pay;
		this.hr_reg = hr_reg;
		this.hr_over = hr_over;
	}

	public float getHr_pay() {
		return hr_pay;
	}

	public void setHr_pay(float hr_pay) {
		this.hr_pay = hr_pay;
	}

	public int getHr_reg() {
		return hr_reg;
	}

	public void setHr_reg(int hr_reg) {
		this.hr_reg = hr_reg;
	}

	public int getHr_over() {
		return hr_over;
	}

	public void setHr_over(int hr_over) {
		this.hr_over = hr_over;
	}
	
}
