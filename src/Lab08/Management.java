package Lab08;

public class Management {
	public static void payEquity(Employee emp1, Employee emp2) {
		if (emp1.getGender().equalsIgnoreCase("F")) {
			if (emp2.getGender().equalsIgnoreCase("M")) {
				if (emp1.getSalary() < emp2.getSalary()) {
					emp1.setSalary(emp2.getSalary());
				}
			}
		}
	}
	
	public static void promotion(Employee emp) {
		if (emp.getYearsOfService() > 7) {
			emp.setSalary(emp.getSalary() * 1.1);
		}
	}
}
