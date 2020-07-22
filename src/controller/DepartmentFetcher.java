package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import DAO.DepartmentOperations;
import DAO.EmployeeOperations;
import model.Department;
import model.Employee;

public class DepartmentFetcher {
	Department dept=null;
	DepartmentOperations dep=new DepartmentOperations();
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	public void departmentHandle() throws Exception {
		System.out.println("Hi what would you like to do?");
		System.out.println("1. ADD DEPARTMENT DETAILS");
		System.out.println("2. CHANGE SUPERVISOR DETAILS");
		System.out.println("3. DISPLAY ALL DEPARTMENTS");
		System.out.println("4. DISPLAY SPECIFIC DEPARTMENT");
		int x=Integer.parseInt(br.readLine());
		switch(x) {
		case 1:
			System.out.println("Enter department id");
			String id=br.readLine();
			System.out.println("Enter department name");
			String name=br.readLine();
			System.out.println("Enter supervisor id");
			String sup_id=br.readLine();
			System.out.println("Enter supervisor name");
			String sup_name=br.readLine();
			
			
			dept=new Department(id,name,sup_id,sup_name);
			try {
				dep.addDepartment(dept);
			}
			catch(Exception e) {
				e.getMessage();
			}
			System.out.println("Added Successfully");
			break;
			
		case 2 :
			System.out.println("Enter department id");
			String id1=br.readLine();
			dep.changeSupervisor(id1);
			break;
			
		case 3:
			System.out.println("Displaying all departments");
			dep.getAllDepartments();
			break;
		
		case 4:
			System.out.println("Enter department id");
			String id2=br.readLine();
			dep.getSpecificDepartment(id2);
	}
	
	
	
}
}