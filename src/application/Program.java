package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Employee;
import model.exceptions.EmployeeException;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Employee> list = new ArrayList<>();
		
		try {
			System.out.print("Number of employees to be registered: ");
			int N = sc.nextInt();
			
			for (int i=0; i<N; i++) {
				System.out.println();
				System.out.print("ID: ");
				Integer id = sc.nextInt();
				while (findId(list, id)) {
					System.out.print("This ID already exists! Try again: ");
					id = sc.nextInt();
				}
				System.out.println();
				System.out.println("Enter information about the employee (#" + id + "):");
				System.out.print("Name: ");
				sc.nextLine();
				String name = sc.nextLine();
				System.out.print("Salary: ");
				Double salary = sc.nextDouble();
				
				Employee employee = new Employee(id, name, salary);
				employee.EmployeeExceptions();
				list.add(employee);
			}
			
			System.out.println();
			System.out.print("Enter the ID of the employee who will receive a salary increase: ");
			int salaryId = sc.nextInt();
			
			Employee employee = list.stream().filter(x -> x.getId() == salaryId).findFirst().orElse(null);
			
			if (employee == null) {
				System.out.println("This ID doesn't exist!");
			}
			else {
				System.out.print("Enter the percentage of salary increase: ");
				double percentage = sc.nextDouble();
				employee.salaryIncrease(percentage);
			}
			
			System.out.println();
			System.out.println("Employee list: ");
			for (Employee employeeList : list) {
				System.out.println(employeeList);
			}
		}
		catch (InputMismatchException error) {
			System.out.println("Error! Enter a number or a integer number.");
		}
		catch (EmployeeException error) {
			System.out.println(error.getMessage());
		}
		
		sc.close();
	}
	
	public static Integer idPosistion(List<Employee> listPosition, int id) {
		for (int i=0; i<listPosition.size(); i++) {
			if (listPosition.get(i).getId() == id) {
				return i;
			}
		}
		return null;
	}
	
	public static boolean findId(List<Employee> findList, int id) {
		Employee employee = findList.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return employee != null;
	}
}
