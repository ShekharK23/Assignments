package classAssignment;

public class CalcSal {
	
	public static void main(String[] args) {
		Employee emp = new Employee();
		emp.setHr_reg(100);
		int over1 = (int) (100 * 1.5);
		emp.setHr_over(over1);
		
		int reg = emp.getHr_reg();
		int over = emp.getHr_over();
		int reg_hr_worked = 40;
		int over_hr_worked = 10;
		
		System.out.println("Hourly regular Salary = "+reg);
		System.out.println("Hourly Overtime Salary = "+over);
		System.out.println("Regular time in week = "+reg_hr_worked);
		System.out.println("Overtime time in week = "+over_hr_worked);
		
		CalcSal cs = new CalcSal();
		float res = cs.CalculateSalary(reg, over, reg_hr_worked, over_hr_worked);
		cs.Display(res);
	}
	
	public int CalculateSalary(int reg,int over, int reg_hr_worked, int over_hr_worked) {
		int pay = (reg * reg_hr_worked) + (over * over_hr_worked);
		return pay;
		
	}
	
	public void Display(float pay) {
		System.out.println("Weekly Salary of Employee = "+pay);
	}
}