package DAO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.xml.transform.Result;

import model.Employee;
import utility.ConnectionManager;

public class EmployeeOperations {

	Employee emp=null;
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	public void addEmployee(Employee emp) throws Exception {
		Connection con=ConnectionManager.getConnection();
		String sql="INSERT INTO EMPLOYEE(emp_id,emp_name,emp_email,emp_department,emp_position,salary,emp_phone)VALUES(?,?,?,?,?,?,?)";
		PreparedStatement st=con.prepareStatement(sql);
		
		
		st.setString(1, emp.getEid());
		st.setString(2, emp.getEname());
		st.setString(3, emp.getEmail());
		st.setString(4, emp.getDepartment());
		st.setString(5, emp.getPosition());
		st.setLong(6, emp.getSalary());
		st.setLong(7, emp.getPhone());
		
		st.executeUpdate();
		con.close();
	}
	
	public void updateEmployee(String id) throws Exception {
		
		
		int result;
		
		Connection con=ConnectionManager.getConnection();
		
		String sql="UPDATE employee SET emp_name=?,emp_email=?,emp_department=?,emp_position=?,salary=?,emp_phone=? WHERE emp_id=?";
		
		PreparedStatement st1=con.prepareStatement(sql);
		
		
		
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
		
		
		
		st1.setString(1, emp.getEname());
		st1.setString(2, emp.getEmail());
		st1.setString(3, emp.getDepartment());
		st1.setString(4, emp.getPosition());
		st1.setInt(5, emp.getSalary());
		st1.setLong(6, emp.getPhone());
		st1.setString(7, emp.getEid());
		
		result=st1.executeUpdate();
		
		System.out.println(result);
		
		
		if(result>0) {
			System.out.println("Employee Id = "+id+" has been updated successfully");
		}
		else {
			System.out.println("Employee Id = "+id+" has not been updated");
		}
	
		con.close();
	
	}
	
	public void deleteEmployees(String id) {
		try {
			int result;
			
			Connection con=ConnectionManager.getConnection();
		
			String sql="Delete from employee where Emp_id=?";			
			
			PreparedStatement st2=con.prepareStatement(sql);
			st2.setString(1, id);
			result=st2.executeUpdate();
			if(result!=0) {
				System.out.println("Employee Id = "+id+" has been deleted successfully");
			}
			else {
				System.out.println("Employee Id = "+id+" has not been deleted");
			}
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public void getAllEmployees() {
		try {
			int result;
			Connection con = ConnectionManager.getConnection();
			String sql="SELECT * from EMPLOYEE";
			Statement st= con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				System.out.println(rs.getString(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getString(3)+"\t\t"+rs.getString(4)+"\t\t"+rs.getString(5)+"\t\t"+rs.getString(6)+"\t\t"+rs.getString(7));
			}
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	
	public void getFromDept(String dept) {
	try {
		int result;
		Connection con = ConnectionManager.getConnection();
		
		String sql="SELECT * from EMPLOYEE WHERE emp_department=?";
		PreparedStatement st4= con.prepareStatement(sql);
		st4.setString(1, dept);
		ResultSet rs=st4.executeQuery();	
		
		
		/*ResultSet rs=st.executeQuery("SELECT * from EMPLOYEE WHERE EMP_DEPARTMENT=?");*/
		while(rs.next()) {
			System.out.println(rs.getString(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getString(3)+"\t\t"+rs.getString(4)+"\t\t"+rs.getString(5)+"\t\t"+rs.getString(6)+"\t\t"+rs.getString(7));
		}
		con.close();
	}
	catch(Exception e) {
		System.out.println(e);
	}
	}
	
	
	public void getFromPosition(String pos) {
	try {
		int result;
		Connection con = ConnectionManager.getConnection();
		String sql="SELECT * from EMPLOYEE WHERE EMP_POSITION=?";
		PreparedStatement st5= con.prepareStatement(sql);
		st5.setString(1, pos);
		ResultSet rs=st5.executeQuery();
		
		
		while(rs.next()) {
			System.out.println(rs.getString(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getString(3)+"\t\t"+rs.getString(4)+"\t\t"+rs.getString(5)+"\t\t"+rs.getString(6)+"\t\t"+rs.getString(7));
		}
		con.close();
	}
	catch(Exception e) {
		System.out.println(e);
	}
	}
	
	
}
