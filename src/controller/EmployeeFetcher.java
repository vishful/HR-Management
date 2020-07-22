package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import DAO.EmployeeOperations;
import model.Employee;

public class EmployeeFetcher {
	Employee emp=null;
	EmployeeOperations empl=new EmployeeOperations();
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
public void employeeHandle() throws Exception {	
	System.out.println("Hi what would you like to do?");
	System.out.println("1. ADD EMPLOYEE DETAILS");
	System.out.println("2. UPDATE DETAILS OF EMPLOYEE");
	System.out.println("3. DELETE/FIRE AN EMPLOYEE");
	System.out.println("4. GET ALL EMPLOYEE DETAILS");
	System.out.println("5. GET ALL EMPLOYEES FROM A DEPARTMENT");
	System.out.println("6. GET ALL EMPLOYEES AT CERTAIN POSITIONS");
	int x=Integer.parseInt(br.readLine());
	switch(x) {
	case 1:
		System.out.println("Enter employee id");
		String id=br.readLine();
		System.out.println("Enter employee name");
		String name=br.readLine();
		System.out.println("Enter employee email");
		String email=br.readLine();
		System.out.println("Enter employee phone");
		long phone=Long. parseLong(br. readLine());
		System.out.println("Enter employee department");
		String dep=br.readLine();
		System.out.println("Enter employee position");
		String position=br.readLine();
		System.out.println("Enter employee salary");
		int salary=Integer.parseInt(br.readLine());
		
		
		emp=new Employee(id,name,email,dep,position,salary,phone);
		try {
			empl.addEmployee(emp);
		}
		catch(Exception e) {
			e.getMessage();
		}
		System.out.println("Added Successfully");
		break;
		
		
		
		
	case 2:
		
		System.out.println("Enter the ID of the employee that you want to update");
		String idAlter=br.readLine();
		empl.updateEmployee(idAlter);
		break;
		
		
	case 3:
		System.out.println("Enter the ID of the employee that you want to delete");
		String idDelete=br.readLine();
		empl.deleteEmployees(idDelete);
		break;
		
		
	case 4:
		System.out.println("Fetching all employee details");
		empl.getAllEmployees();
		break;
		
		
	case 5:
		System.out.println("Enter department name");
		String dept=br.readLine();
		empl.getFromDept(dept);
		break;
		
		
	case 6:
		System.out.println("Enter name of position");
		String pos=br.readLine();
		empl.getFromPosition(pos);
		break;
		}

		}
	}

