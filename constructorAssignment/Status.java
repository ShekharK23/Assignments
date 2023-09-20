package constructorAssignment;

public class Status {
	
	public static void main(String[] args) {
		
		Employee emp1 = new Employee("Shekhar",'M');
		
		System.out.println("Employee1 Information Before Promoting -");
		System.out.println("Employee1 Name = "+emp1.getName());
		System.out.println("Employee1 Gender = "+emp1.getGender());
		System.out.println("Employee1 Experience = "+emp1.getYearsOfExp());
		System.out.println("Employee1 Designation = "+emp1.getDesignation());
		System.out.println("Employee1 Basic Salary = "+emp1.getBasicSalary());
		System.out.println("Employee1 Status = "+emp1.getStatus());
		
		double sal = promoteEmpSal(emp1.getDesignation(),emp1.getBasicSalary());
		emp1.setBasicSalary(sal);
		String desc = promoteEmpDesc(emp1.getDesignation());
		emp1.setDesignation(desc);
		
		System.out.println("\nEmployee1 Information After Promoting -");
		System.out.println("Employee1 Designation = "+emp1.getDesignation());
		System.out.println("Employee1 Basic Salary = "+emp1.getBasicSalary());
		System.out.println("Employee1 Status = "+emp1.getStatus());
		
		
Employee emp2 = new Employee("Sanket",'M',4);
		
		System.out.println("\nEmployee2 Information Before Promoting -");
		System.out.println("Employee2 Name = "+emp2.getName());
		System.out.println("Employee2 Gender = "+emp2.getGender());
		System.out.println("Employee2 Experience = "+emp2.getYearsOfExp());
		System.out.println("Employee2 Designation = "+emp2.getDesignation());
		System.out.println("Employee2 Basic Salary = "+emp2.getBasicSalary());
		System.out.println("Employee2 Status = "+emp2.getStatus());
		
		
		double sal1 = promoteEmpSal(emp2.getDesignation(),emp2.getBasicSalary());
		emp2.setBasicSalary(sal1);
		String desc1 = promoteEmpDesc(emp2.getDesignation());
		emp2.setDesignation(desc1);
		
		System.out.println("\nEmployee Information After Promoting -");
		System.out.println("Employee2 Designation = "+emp2.getDesignation());
		System.out.println("Employee2 Basic Salary = "+emp2.getBasicSalary());
		System.out.println("Employee2 Status = "+emp2.getStatus());
	}
	
	public static double promoteEmpSal(String designation, double basicSalary) {
		if (designation == "ASE") {
			 basicSalary *= 1.05;
		} else if (designation == "ITA") {
			 basicSalary *= 1.08;
		} else if (designation == "AST") {
			 basicSalary *= 1.10;
		} 
		return basicSalary;
	}
	
	public static String promoteEmpDesc(String designation) {
		if (designation == "ASE") {
			 designation = "ITA";
		} else if (designation == "ITA") {
			 designation = "AST";
		} else if (designation == "AST") {
			 designation = "ASC";
		} 
		return designation;
	}
	
	public void applyForLWP(String status, double basicSalary) {
		status = "Inactive";
		basicSalary = 0;
	}
}
