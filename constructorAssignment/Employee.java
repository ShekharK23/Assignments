package constructorAssignment;

public class Employee {

	private String name;
	private char gender;
	private double yearsOfExp;
	private String designation;
	private double basicSalary;
	private String status;
	
	public Employee() {
	}

	public Employee(String name, char gender) {
		this.name = name;
		this.gender = gender;
		this.designation = "ASE";
		this.basicSalary = 10000.0;
		this.status = "Active";
	}

	public Employee(String name, char gender, double yearsOfExp) {
		this.name = name;
		this.gender = gender;
		this.yearsOfExp = yearsOfExp;
		if (yearsOfExp >= 3) {
			this.designation = "ITA";
			this.basicSalary = 15000.0;
			this.status = "Active";
		} else {
			this.designation = "ASE";
			this.basicSalary = 10000.0;
			this.status = "Active";
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public double getYearsOfExp() {
		return yearsOfExp;
	}

	public void setYearsOfExp(double yearsOfExp) {
		this.yearsOfExp = yearsOfExp;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public double getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(double basicSalary) {
		this.basicSalary = basicSalary;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
