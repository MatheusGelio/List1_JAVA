package model.entities;

import model.exceptions.EmployeeException;

public class Employee {	
	
	private Integer id;
	private String name;
	private Double salary;
	
	public Employee(Integer id, String name, Double salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public void salaryIncrease (double percentage ) {
		salary += salary * percentage / 100;
	}
	
	public void EmployeeExceptions() {
		if (salary < 0) {
			throw new EmployeeException("Error! Enter a positive number!");
		}
	}
	
	@Override
	public String toString() {
		return "(#" + id + ")" + " - " + name + ": $" + String.format("%.2f", salary);
	}
}
